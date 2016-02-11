package _2016.model;

import java.util.List;

public class Order {

    public final int index;
    public final Position position;
    public final List<Item> expecteditems;

    public Order(int index, Position position, List<Item> expecteditems) {
        this.index = index;
        this.position = position;
        this.expecteditems = expecteditems;
    }
}
