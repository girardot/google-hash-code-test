package _2016.model;

import java.util.List;

public class Warehouse {

    public final List<Item> items;
    public final Position position;

    public Warehouse( Position position,List<Item> items) {
        this.items = items;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "items=" + items +
                ", position=" + position +
                '}';
    }
}
