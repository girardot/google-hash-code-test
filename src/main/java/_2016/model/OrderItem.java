package _2016.model;

public class OrderItem {

    public final int type;
    public final int count;

    public OrderItem(int type, int count) {
        this.type = type;
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "type=" + type +
                ", count=" + count +
                '}';
    }
}
