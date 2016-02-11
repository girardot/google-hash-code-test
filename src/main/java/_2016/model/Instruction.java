package _2016.model;

import java.io.IOException;
import java.io.Writer;

public class Instruction {

    public final InstructionType instructionType;

    public final int wareHouse;

    public final int productType;

    public final int productNumber;

    public final int customer;

    public Instruction(InstructionType instructionType, int wareHouse, int productType, int productNumber, int customer) {
        this.instructionType = instructionType;
        this.wareHouse = wareHouse;
        this.productType = productType;
        this.productNumber = productNumber;
        this.customer = customer;
    }

    public void write(int drone, Writer writer) throws IOException {
        switch (instructionType) {

            case LOAD:
                writer.write(drone + " " + instructionType.getL() + " " + wareHouse + " " + productType + " " + productNumber + "\n");
                break;
            case DELIVER:
                writer.write(drone + " " + instructionType.getL() + " " + customer + " " + productType + " " + productNumber + "\n");
                break;
        }

    }

}
