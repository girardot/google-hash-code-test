package _2016.model;

public class OrderItem {

    public final int type;
    public final int count;

    // TODO refactor
    public boolean isDone = false;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem item = (OrderItem) o;
        return type == item.type && count == item.count;
    }

    @Override
    public int hashCode() {
        int result = type;
        result = 31 * result + count;
        return result;
    }
}
