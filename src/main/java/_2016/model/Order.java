package _2016.model;

import java.util.List;

public class Order {

    public final Position position;
    public final List<Item> expecteditems;

    public Order(Position position, List<Item> expecteditems) {
        this.position = position;
        this.expecteditems = expecteditems;
    }
}
