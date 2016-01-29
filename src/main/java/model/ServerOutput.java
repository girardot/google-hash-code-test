package model;

public class ServerOutput {

    public int row, slot, pool, index, capacity;

    public boolean placed;

    public ServerOutput(int row, int slot, int pool, boolean placed, int index, int capacity) {
        this.row = row;
        this.slot = slot;
        this.pool = pool;
        this.placed = placed;
        this.index = index;
        this.capacity = capacity;
    }

    public String print() {
        if (placed) {
            return row + " " + slot + " " + pool;
        }
        return "x";
    }

    @Override
    public String toString() {
        return "ServerOutput{" +
                "row=" + row +
                ", slot=" + slot +
                ", pool=" + pool +
                ", placed=" + placed +
                '}';
    }
}
