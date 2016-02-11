package _2016.model;

import java.util.List;

public class Warehouse {

    public final int index;
    public final List<Item> items;
    public final Position position;

    public Warehouse(int index, Position position, List<Item> items) {
        this.index = index;
        this.items = items;
        this.position = position;
    }

    public boolean containsItemsWithType(int type){
        return items.stream()
                .anyMatch(item -> item.type == type);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "items=" + items +
                ", position=" + position +
                '}';
    }

    public void decrement(int productType, int numberProduct) {

        for (int i = 0; i < numberProduct; i++) {
            items.stream()
                    .filter(item -> item.type == productType)
                    .findFirst().ifPresent(items::remove);
        }


    }
}
