package _2016.model;

import java.io.IOException;
import java.io.Writer;

import static _2016.model.InstructionType.DELIVER;
import static _2016.model.InstructionType.LOAD;

public class Instruction {

    public InstructionType instructionType;

    public Warehouse wareHouse;

    public int productType;

    public int productNumber;

    public Order order;

    private Instruction(InstructionType instructionType) {
        this.instructionType = instructionType;
    }

    public static Instruction buildLoadInstruction(Warehouse wareHouse, int productType, int productNumber) {
        final Instruction instruction = new Instruction(LOAD);
        instruction.wareHouse = wareHouse;
        instruction.productType = productType;
        instruction.productNumber = productNumber;
        return instruction;
    }

    public static Instruction buildDeliverInstruction(Order order, int productType, int productNumber) {
        final Instruction instruction = new Instruction(DELIVER);
        instruction.order = order;
        instruction.productType = productType;
        instruction.productNumber = productNumber;
        return instruction;
    }

    public void write(int drone, Writer writer) throws IOException {
        switch (instructionType) {
            case LOAD:
                writer.write(drone + " " + instructionType.getLetter() + " " + wareHouse.index + " " + productType + " " + productNumber + "\n");
                break;
            case DELIVER:
                writer.write(drone + " " + instructionType.getLetter() + " " + order.index + " " + productType + " " + productNumber + "\n");
                break;
        }
    }

    @Override
    public String toString() {
        String result = "";
        switch (instructionType) {
            case LOAD:
                result = instructionType + " from warehouse : " + wareHouse.index + ", " + productNumber + "  product(s) of type: " + productType;
                break;
            case DELIVER:
                result = (instructionType + " order : " + order.index + ", " + productNumber + "  product(s) of type : " + productType);
                break;
        }
        return result;
    }
}
