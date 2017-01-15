package _2016.model;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Drone {

    public final int index;

    public final List<Instruction> instructions;

    public Drone(int index) {
        this.index = index;
        this.instructions = new ArrayList<>();
    }

    public void load(int productType, int numberProduct, Warehouse warehouse) {
        instructions.add(new Instruction(InstructionType.LOAD, warehouse.index, productType, numberProduct, 0));
    }

    public void deliver(int productType, int numberProduct, Order order) {
        instructions.add(new Instruction(InstructionType.DELIVER, 0, productType, numberProduct, order.index));
    }

    public void write(Writer writer) throws IOException {
        for (Instruction instruction : instructions) {
            instruction.write(index, writer);
        }
    }
}
