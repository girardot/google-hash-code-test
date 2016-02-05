package _2015.model;

public class Line1 {

    public final int row, nbSlot, slotUnavable, nbPool, server;

    public Line1(int row, int nbSlot, int slotUnavable, int nbPool, int server) {
        this.row = row;
        this.nbSlot = nbSlot;
        this.slotUnavable = slotUnavable;
        this.nbPool = nbPool;
        this.server = server;
    }

    @Override
    public String toString() {
        return "Line1{" +
                "row=" + row +
                ", nbSlot=" + nbSlot +
                ", slotUnavable=" + slotUnavable +
                ", nbPool=" + nbPool +
                ", server=" + server +
                '}';
    }
}
