package _2016.score;

import _2016.model.Instruction;
import _2016.model.InstructionType;
import _2016.model.Position;

import java.util.Iterator;
import java.util.List;

import static _2016.model.InstructionType.LOAD;

public class ScoreDrone {
    private Position position = new Position(0, 0);
    private final Iterator<Instruction> instructionIterator;
    private Instruction currentInstruction;
    public final int index;
    public final int maxPayLoad;

    ScoreDrone(int index, List<Instruction> instructions, int maxPayLoad) {
        this.index = index;
        this.maxPayLoad = maxPayLoad;
        this.instructionIterator = instructions.iterator();
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
        System.out.println("Drone(" + index + ") is loading item " + instruction.productType + " from warehouse " + instruction.wareHouse.index);
    }

    public void deliver(Instruction instruction) {
        System.out.println("Drone(" + index + ") is deliver item " + instruction.productType + " to order " + instruction.order.index);
    }
}
