package _2016.model;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Drone {

    public final int index;

    public final List<Instruction> instructions;

    public int numberTurn;

    public Position position;
    private boolean canFly = true;

    public Drone(int index, int numberTurn, Position position) {
        this.index = index;
        this.numberTurn = numberTurn;
        this.position = position;
        this.instructions = new ArrayList<>();
    }

    public void load(int productType, int numberProduct, Warehouse warehouse) {
        moveTo(warehouse.position);
        if (canFly()) {
            instructions.add(new Instruction(InstructionType.LOAD, warehouse.index, productType, numberProduct, 0));
            position = warehouse.position;
            warehouse.decrement(productType, numberProduct);
        }
    }

    public void deliver(int productType, int numberProduct, Order order) {
        moveTo(order.position);
        if (canFly()) {
            instructions.add(new Instruction(InstructionType.DELIVER, 0, productType, numberProduct, order.index));
            position = order.position;
        }
    }

    private void moveTo(Position position) {
        int numberTurnTmp = numberTurn - (distance(position) + 1);
        if (numberTurnTmp < 0) {
            canFly = false;
        } else {
            numberTurn = numberTurnTmp;
        }
    }

    private int distance(Position position) {
        return (int) Math.ceil(sqrt(pow(position.x - this.position.x, 2) + pow(position.y - this.position.y, 2)));
    }

    public void write(Writer writer) throws IOException {
        for (Instruction instruction : instructions) {
            instruction.write(index, writer);
        }
    }

    public int numberInstructions() {
        return instructions.size();
    }

    public boolean canFly() {
        return canFly;
    }

}
