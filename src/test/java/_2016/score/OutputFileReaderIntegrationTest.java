package _2016.score;

import _2016.input.InputReader;
import _2016.model.Order;
import _2016.model.Warehouse;
import _2016.model.World;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static _2016.model.Instruction.buildDeliverInstruction;
import static _2016.model.Instruction.buildLoadInstruction;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputFileReaderIntegrationTest {
    private World world;
    private final OutputFileReader outputFileReader = new OutputFileReader();

    @Before
    public void setUp() throws Exception {
        world = new InputReader().parse("/simple.in");
    }

    @Test
    public void should_parse_output_file() throws FileNotFoundException {
        // Given / When
        final List<ScoreDrone> drones = outputFileReader.parse("/output_simple.in", world);

        //Then
        assertThat(drones).hasSize(2);
        assertThat(drones.get(0).getInstructions()).containsExactly(
                buildLoadInstruction(getWarehouse(0), 0, 1),
                buildLoadInstruction(getWarehouse(0), 1, 1),
                buildDeliverInstruction(getOrder(0), 0, 1),
                buildLoadInstruction(getWarehouse(1), 2, 1),
                buildDeliverInstruction(getOrder(0), 2, 1)
        );

        assertThat(drones.get(1).getInstructions()).containsExactly(
                buildLoadInstruction(getWarehouse(1), 2, 1),
                buildDeliverInstruction(getOrder(2), 2, 1),
                buildLoadInstruction(getWarehouse(0), 0, 1),
                buildDeliverInstruction(getOrder(1), 0, 1)
        );
    }

    private Warehouse getWarehouse(int i) {
        return world.warehouses.get(i);
    }

    private Order getOrder(int i) {
        return world.orders.get(i);
    }
}