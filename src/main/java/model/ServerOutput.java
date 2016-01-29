package model;

public class ServerOutput {

    public int row, slot, pool;

    public boolean placed;

    public ServerOutput(int row, int slot, int pool, boolean placed) {
        this.row = row;
        this.slot = slot;
        this.pool = pool;
        this.placed = placed;
    }

    public String print() {
        if (placed) {
            return row + " " + slot + " " + pool;
        }
        return "x";
    }

}
