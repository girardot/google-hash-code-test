package _2016.score;

import _2016.model.Instruction;
import _2016.model.InstructionType;
import _2016.model.Position;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static _2016.model.InstructionType.LOAD;
import static org.slf4j.LoggerFactory.getLogger;

public class ScoreDrone {
    public final Logger LOGGER = getLogger(ScoreDrone.class);

    private Iterator<Instruction> instructionIterator;
    private Instruction currentInstruction;
    private Position position = new Position(0, 0);
    private Map<Integer, Integer> itemsCarried = new HashMap<>();

    public final int maxPayLoad;
    private final List<Integer> productWeights;
    public final int index;

    public ScoreDrone(int index, List<Instruction> instructions, int maxPayLoad, List<Integer> productWeights) {
        this.index = index;
        this.maxPayLoad = maxPayLoad;
        this.productWeights = productWeights;
        if (instructions != null) {
            this.instructionIterator = instructions.iterator();
        }
        getNextInstruction();
    }

    public Instruction getNextInstruction() {
        currentInstruction = null;
        if (instructionIterator.hasNext()) {
            currentInstruction = instructionIterator.next();
        }
        return currentInstruction;
    }

    public Instruction getCurrentInstruction() {
        return currentInstruction;
    }

    public Map<Integer, Integer> getItemsCarried() {
        return itemsCarried;
    }

    public boolean moveTo(Position destination, InstructionType instructionType) {
        int distanceToDestination = position.distance(destination);
        boolean hasMove = false;
        if (distanceToDestination != 0) {
            LOGGER.debug("Drone(" + index + ") " + position + " is moving to " + (LOAD.equals(instructionType) ? "warehouse" : "client") + destination);
            position = position.moveToDestination(destination);
            LOGGER.debug(" -----> new drone(" + index + ") position is  " + position);
            hasMove = true;
        }
        return hasMove;
    }

    public void load(Instruction instruction) {
        if (canLoadItems(instruction.productType, instruction.productNumber)) {
            loadProduct(instruction.productType, instruction.productNumber);
            LOGGER.debug("Drone(" + index + ") is loading " + instruction.productNumber + " item(s) " + instruction.productType + " from warehouse " + instruction.wareHouse.index);
        } else {
            LOGGER.debug("WARNING !!!!!!! Max payload reached !!!!!!!!!!!!");
            LOGGER.debug("WARNING !!!!!!! Drone(" + index + ") cannot load " + instruction.productNumber + " item(s) " + instruction.productType + " from warehouse " + instruction.wareHouse.index);
        }
    }

    public void deliver(Instruction instruction) {
        if (hasProducts(instruction.productType, instruction.productNumber)) {
            unloadProduct(instruction.productType, instruction.productNumber);
            LOGGER.debug("Drone(" + index + ") is deliver item " + instruction.productType + " to order " + instruction.order.index);
        } else {
            LOGGER.debug("WARNING !!!!!!! Deliver failed !!!!!!!!!!!!");
            LOGGER.debug("WARNING !!!!!!! Drone(" + index + ") does not has " + instruction.productNumber + " " + instruction.productType);
        }
    }

    private boolean hasProducts(int productType, int productNumber) {
        return itemsCarried.getOrDefault(productType, 0) >= productNumber;
    }

    private void loadProduct(int productType, int numberToLoad) {
        itemsCarried.put(
                productType,
                itemsCarried.getOrDefault(productType, 0) + numberToLoad
        );
    }

    private void unloadProduct(int productType, int numberToUnload) {
        loadProduct(productType, (-1 * numberToUnload));
    }

    private boolean canLoadItems(int productType, int productNumber) {
        return productNumber * productWeights.get(productType) + itemsCarriedWeight() < maxPayLoad;
    }

    private int itemsCarriedWeight() {
        int totalCarriedWeight = 0;
        for (Map.Entry<Integer, Integer> entry : itemsCarried.entrySet()) {
            totalCarriedWeight = productWeights.get(entry.getKey()) * entry.getValue();
        }
        return totalCarriedWeight;
    }
}
