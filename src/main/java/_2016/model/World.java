package _2016.model;

import java.util.List;

public class World {

    private final int rows;
    private final int columns;
    private final int drones;
    private final int turns;
    private final int maxPayLoad;
    public  List<Warehouse> warehouses;
    public  List<Order> orders;


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
                '}';
    }
}
