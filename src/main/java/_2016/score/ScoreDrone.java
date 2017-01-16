package _2016.score;

import _2016.model.Instruction;
import _2016.model.InstructionType;
import _2016.model.Position;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static _2016.model.InstructionType.LOAD;

public class ScoreDrone {

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
            System.out.print("Drone(" + index + ") " + position + " is moving to " + (LOAD.equals(instructionType) ? "warehouse" : "client") + destination);
            position = position.moveToDestination(destination);
            System.out.println(" -----> new drone(" + index + ") position is  " + position);
            hasMove = true;
        }
        return hasMove;
    }

    public void load(Instruction instruction) {
        if (instruction.productNumber * productWeights.get(instruction.productType) + itemsCarriedWeight() < maxPayLoad) {
            itemsCarried.put(
                    instruction.productType,
                    itemsCarried.getOrDefault(instruction.productType, 0) + instruction.productNumber
            );
            System.out.println("Drone(" + index + ") is loading " + instruction.productNumber + " item(s) " + instruction.productType + " from warehouse " + instruction.wareHouse.index);
        } else {
            System.out.println("WARNING !!!!!!! Max payload reached !!!!!!!!!!!!");
            System.out.println("WARNING !!!!!!! Drone(" + index + ") cannot load " + instruction.productNumber + " item(s) " + instruction.productType + " from warehouse " + instruction.wareHouse.index);
        }
    }

    private int itemsCarriedWeight() {
        int totalCarriedWeight = 0;
        for (Map.Entry<Integer, Integer> entry : itemsCarried.entrySet()) {
            totalCarriedWeight = productWeights.get(entry.getKey()) * entry.getValue();
        }
        return totalCarriedWeight;
    }

    public void deliver(Instruction instruction) {
        System.out.println("Drone(" + index + ") is deliver item " + instruction.productType + " to order " + instruction.order.index);
    }
}
