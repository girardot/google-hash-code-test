package _2016.model;

import java.util.List;

public class Warehouse {

    public final List<Item> items;
    public final Position position;

    public Warehouse(List<Item> items, Position position) {
        this.items = items;
        this.position = position;
    }
}
