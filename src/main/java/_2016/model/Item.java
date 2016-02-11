package _2016.model;

public class Item {

    public final int type;
    private final int count;

    public Item(int type, int count) {
        this.type = type;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type=" + type +
                ", count=" + count +
                '}';
    }
}
