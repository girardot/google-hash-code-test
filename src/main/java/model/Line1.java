package model;

public class Line1 {

    public final int row, slot, slotUnavable, pool, server;

    public Line1(int row, int slot, int slotUnavable, int pool, int server) {
        this.row = row;
        this.slot = slot;
        this.slotUnavable = slotUnavable;
        this.pool = pool;
        this.server = server;
    }

    @Override
    public String toString() {
        return "Line1{" +
                "row=" + row +
                ", slot=" + slot +
                ", slotUnavable=" + slotUnavable +
                ", pool=" + pool +
                ", server=" + server +
                '}';
    }
}
