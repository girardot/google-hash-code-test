package _2016.score;


import _2016.input.InputReader;
import _2016.model.Drone;
import _2016.model.World;
import org.junit.Before;
import org.junit.Test;

import static _2016.model.Instruction.buildDeliverInstruction;
import static _2016.model.Instruction.buildLoadInstruction;
import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoreProcessorIntegrationTest {

    private final ScoreProcessor scoreProcessor = new ScoreProcessor();
    private World world;

    @Before
    public void setUp() throws Exception {
        InputReader inputReader = new InputReader();
        world = inputReader.parse("/simple.in");
    }

    @Test
    public void should_compute_score_for_one_drone() {
        // Given
        Drone drone = new Drone(0);

        drone.instructions.add(buildLoadInstruction(world.warehouses.get(0), 0, 1));
        drone.instructions.add(buildLoadInstruction(world.warehouses.get(0), 1, 1));
        drone.instructions.add(buildDeliverInstruction(world.orders.get(0), 0, 1));
        drone.instructions.add(buildLoadInstruction(world.warehouses.get(1), 2, 1));
        drone.instructions.add(buildDeliverInstruction(world.orders.get(0), 2, 1));

        // When
        int score = scoreProcessor.computeScore(world, newArrayList(drone), world.warehouses);

        // Then
        assertThat(score).isEqualTo(64);
    }

    @Test
    public void should_compute_score_for_two_drones() {
        // Given
        Drone drone1 = new Drone(0);

        drone1.instructions.add(buildLoadInstruction(world.warehouses.get(0), 0, 1));
        drone1.instructions.add(buildLoadInstruction(world.warehouses.get(0), 1, 1));
        drone1.instructions.add(buildDeliverInstruction(world.orders.get(0), 0, 1));
        drone1.instructions.add(buildLoadInstruction(world.warehouses.get(1), 2, 1));
        drone1.instructions.add(buildDeliverInstruction(world.orders.get(0), 2, 1));

        Drone drone2 = new Drone(1);
        drone2.instructions.add(buildLoadInstruction(world.warehouses.get(1), 2, 1));
        drone2.instructions.add(buildDeliverInstruction(world.orders.get(2), 2, 1));
        drone2.instructions.add(buildLoadInstruction(world.warehouses.get(0), 0, 1));
        drone2.instructions.add(buildDeliverInstruction(world.orders.get(1), 0, 1));

        // When
        int score = scoreProcessor.computeScore(world, newArrayList(drone1, drone2), world.warehouses);

        // Then
        assertThat(score).isEqualTo(194);
    }

}
