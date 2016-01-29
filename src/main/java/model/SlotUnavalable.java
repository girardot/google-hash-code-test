package model;

public class SlotUnavalable {


    public final int row, slot;

    public SlotUnavalable(int row, int slot) {
        this.row = row;
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "SlotUnavalable{" +
                "row=" + row +
                ", slot=" + slot +
                '}';
    }
}
