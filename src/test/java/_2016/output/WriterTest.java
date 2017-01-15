package _2016.output;

import _2016.model.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

public class WriterTest {

    @Test
    public void should_write() throws IOException {
        // Given
        Writer writer = new Writer();

        Item item = new Item(0, 5);

        OrderItem iO1 = new OrderItem(0, 5);
        OrderItem iO2 = new OrderItem(1, 10);

        Order order = new Order(0, new Position(1, 2), newArrayList(iO1, iO2));

        Warehouse w1 = new Warehouse(0, new Position(3, 4), newArrayList(item));
        Warehouse w2 = new Warehouse(0, new Position(3, 4), newArrayList(item));

        Drone drone0 = new Drone(0, 25, w1.position);
        drone0.load(0, 3, w1);
        drone0.deliver(1, 3, order);
        drone0.load(1, 3, w2);
        drone0.load(3, 5, w1);

        Drone drone1 = new Drone(1, 10, w1.position);
        drone1.load(0, 2, w1);
        drone1.load(2, 1, w1);
        drone1.load(3, 5, w1);

        // When
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        writer.write(newArrayList(drone0, drone1), new OutputStreamWriter(outputStream));

        // Then
        assertThat(valueOf(outputStream)).isEqualTo(
                "7\n" +
                        "0 L 0 0 3\n" +
                        "0 D 0 1 3\n" +
                        "0 L 0 1 3\n" +
                        "0 L 0 3 5\n" +
                        "1 L 0 0 2\n" +
                        "1 L 0 2 1\n" +
                        "1 L 0 3 5\n"

        );
    }
}
