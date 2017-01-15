package _2016.model;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static _2016.model.Instruction.buildDeliverInstruction;
import static _2016.model.Instruction.buildLoadInstruction;

public class Drone {

    public final int index;

    public final List<Instruction> instructions;

    public Drone(int index) {
        this.index = index;
        this.instructions = new ArrayList<>();
    }

    public void load(int productType, int numberProduct, Warehouse warehouse) {
        instructions.add(buildLoadInstruction(warehouse.index, productType, numberProduct));
    }

    public void deliver(int productType, int numberProduct, Order order) {
        instructions.add(buildDeliverInstruction(order.index, productType, numberProduct));
    }

    public void write(Writer writer) throws IOException {
        for (Instruction instruction : instructions) {
            instruction.write(index, writer);
        }
    }
}
