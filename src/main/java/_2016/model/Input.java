package _2016.model;

import java.util.List;

public class Input {

    public final Grid grid;
    public final List<Warehouse> warehouses;
    public final List<Order> orders;

    public Input(Grid grid, List<Warehouse> warehouses, List<Order> orders) {
        this.grid = grid;
        this.warehouses = warehouses;
        this.orders = orders;
    }
}
