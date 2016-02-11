package _2016.output;

import _2016.model.*;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

public class WriterTest {

    @Test
    public void should_write() throws IOException {
        // Given
        Writer writer = new Writer();

        Item i1 = new Item(0, 5);
        Item i2 = new Item(1, 10);

        Order order1 = new Order(0, new Position(1, 2), newArrayList(i1, i2));

        Warehouse w1 = new Warehouse(0, new Position(3, 4), newArrayList(i1));
        Warehouse w2 = new Warehouse(0, new Position(3, 4), newArrayList(i1));

        // When
        Drone drone0 = new Drone(0, 25, w1.position);
        drone0.load(0, 3, w1);
        drone0.deliver(1, 3, order1);
        drone0.load(1, 3, w2);
        drone0.load(3, 5, w1);

        Drone drone1 = new Drone(1, 10, w1.position);
        drone1.load(0, 2, w1);
        drone1.load(2, 1, w1);
        drone1.load(3, 5, w1);

        ArrayList<Drone> drones = new ArrayList<>();
        drones.add(drone0);
        drones.add(drone1);

        // Then
        writer.write(drones);
    }
}
