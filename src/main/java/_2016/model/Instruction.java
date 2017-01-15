package _2016.model;

import java.io.IOException;
import java.io.Writer;

import static _2016.model.InstructionType.DELIVER;
import static _2016.model.InstructionType.LOAD;

public class Instruction {

    public InstructionType instructionType;

    public int wareHouse;

    public int productType;

    public int productNumber;

    public int customer;

    private Instruction(InstructionType instructionType) {
        this.instructionType = instructionType;
    }

    public static Instruction buildLoadInstruction(int wareHouse, int productType, int productNumber) {
        final Instruction instruction = new Instruction(LOAD);
        instruction.wareHouse = wareHouse;
        instruction.productType = productType;
        instruction.productNumber = productNumber;
        return instruction;
    }

    public static Instruction buildDeliverInstruction(int customer, int productType, int productNumber) {
        final Instruction instruction = new Instruction(DELIVER);
        instruction.customer = customer;
        instruction.productType = productType;
        instruction.productNumber = productNumber;
        return instruction;
    }

    public void write(int drone, Writer writer) throws IOException {
        switch (instructionType) {
            case LOAD:
                writer.write(drone + " " + instructionType.getLetter() + " " + wareHouse + " " + productType + " " + productNumber + "\n");
                break;
            case DELIVER:
                writer.write(drone + " " + instructionType.getLetter() + " " + customer + " " + productType + " " + productNumber + "\n");
                break;
        }
    }

}
