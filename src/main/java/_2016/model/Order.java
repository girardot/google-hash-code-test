package _2016.model;

import java.util.List;

public class Order {

    public final int index;
    public final Position position;
    public final List<OrderItem> expecteditems;

    public Order(int index, Position position, List<OrderItem> expecteditems) {
        this.index = index;
        this.position = position;
        this.expecteditems = expecteditems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "index=" + index +
                ", position=" + position +
                ", expecteditems=" + expecteditems +
                '}';
    }
}
