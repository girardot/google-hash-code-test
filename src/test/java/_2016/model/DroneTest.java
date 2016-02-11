package _2016.model;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;

public class DroneTest {

    @Test
    public void should_test_writer() throws IOException {
        // Given

        Drone drone0 = new Drone(0, 25);
        drone0.load(0, 3, 0);
        drone0.load(1, 3, 6);
        drone0.load(3, 5, 10);

        Drone drone1 = new Drone(1, 10);
        drone1.load(0, 2, 1);
        drone1.load(2, 1, 2);
        drone1.load(3, 5, 3);

        // When
        PrintWriter writer = new PrintWriter(System.out);
        writer.write(drone0.numberInstructions() + drone1.numberInstructions() + "\n");
        drone0.write(writer);
        drone1.write(writer);
        writer.close();

        // Then
    }
}
