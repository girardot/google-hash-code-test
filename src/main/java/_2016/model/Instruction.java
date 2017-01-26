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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Instruction that = (Instruction) o;

        if (productType != that.productType) return false;
        if (productNumber != that.productNumber) return false;
        if (instructionType != that.instructionType) return false;
        if (wareHouse != null ? !wareHouse.equals(that.wareHouse) : that.wareHouse != null) return false;
        return !(order != null ? !order.equals(that.order) : that.order != null);

    }

    @Override
    public int hashCode() {
        int result = instructionType != null ? instructionType.hashCode() : 0;
        result = 31 * result + (wareHouse != null ? wareHouse.hashCode() : 0);
        result = 31 * result + productType;
        result = 31 * result + productNumber;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    public Position getDestination() {
        Position destination = null;
        if (LOAD.equals(instructionType)) {
            destination = wareHouse.position;
        } else if (DELIVER.equals(instructionType)) {
            destination = order.destination;
        }
        return destination;
    }
}
