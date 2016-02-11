package _2016.output;

import _2016.model.Drone;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class WriterTest {

    @Test
    public void should_write() throws IOException {
        // Given
        Writer writer = new Writer();

        // When
        Drone drone0 = new Drone(0, 25);
        drone0.load(0, 3, 0);
        drone0.load(1, 3, 6);
        drone0.load(3, 5, 10);

        Drone drone1 = new Drone(1, 10);
        drone1.load(0, 2, 1);
        drone1.load(2, 1, 2);
        drone1.load(3, 5, 3);

        ArrayList<Drone> drones = new ArrayList<>();
        drones.add(drone0);
        drones.add(drone1);

        // Then
        writer.write(drones);
    }
}
