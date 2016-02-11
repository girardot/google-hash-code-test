package _2016.model;

import java.util.Arrays;
import java.util.List;

public class World {

    public final int rows;
    public final int columns;
    public final int drones;
    public final int turns;
    public final int maxPayLoad;
    public List<Warehouse> warehouses;
    public List<Order> orders;
    public int[] productTypeWeigh;


    public World(int rows, int columns, int drones, int turns, int maxPayLoad) {
        this.rows = rows;
        this.columns = columns;
        this.drones = drones;
        this.turns = turns;
        this.maxPayLoad = maxPayLoad;
    }


    @Override
    public String toString() {
        return "World{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", drones=" + drones +
                ", turns=" + turns +
                ", maxPayLoad=" + maxPayLoad +
                ", warehouses=" + warehouses +
                ", orders=" + orders +
                ", productTypeWeigh=" + Arrays.toString(productTypeWeigh) +
                '}';
    }

    public Warehouse nextWarehouse(int type) {
        for (int i = 0; i < warehouses.size(); i++) {
            boolean isPresent = warehouses.get(i).items.stream().anyMatch(item -> item.type == type);
            if (isPresent) {
                return warehouses.get(i);
            }
        }
        return null;
    }
}
