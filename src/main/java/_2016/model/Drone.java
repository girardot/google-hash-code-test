package _2016.model;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Drone {

    public final int index;

    public final List<Instruction> instructions;

    public int numberTurn;

    public Drone(int index, int numberTurn) {
        this.index = index;
        this.numberTurn = numberTurn;
        this.instructions = new ArrayList<>();
    }

    public void load(int productType, int numberProduct, int warehouse) {

        numberTurn -= 1;
        instructions.add(new Instruction(InstructionType.LOAD, warehouse, productType, numberProduct, 0));
    }

    public void deliver() {

    }

    public void write(Writer writer) throws IOException {
        for (Instruction instruction : instructions) {
            instruction.write(index, writer);
        }
    }

    public int numberInstructions() {
        return instructions.size();
    }

}
