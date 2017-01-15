package _2016.score;


import _2016.input.InputReader;
import _2016.model.Drone;
import _2016.model.World;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static _2016.model.Instruction.buildDeliverInstruction;
import static _2016.model.Instruction.buildLoadInstruction;
import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoreProcessorTest {

    private final ScoreProcessor scoreProcessor = new ScoreProcessor();
    private World world;

    @Before
    public void setUp() throws Exception {
        InputReader inputReader = new InputReader();
        String fileName = "/simple.in";
        world = inputReader.parse(fileName);
    }

    @Ignore
    @Test
    public void should_compute_score() {
        // Given
        Drone drone = new Drone(0);

        drone.instructions.add(buildLoadInstruction(world.warehouses.get(0), 0, 1));
        drone.instructions.add(buildLoadInstruction(world.warehouses.get(0), 1, 1));
        drone.instructions.add(buildDeliverInstruction(world.orders.get(0), 1, 1));
        drone.instructions.add(buildLoadInstruction(world.warehouses.get(1), 2, 1));
        drone.instructions.add(buildDeliverInstruction(world.orders.get(0), 2, 1));

        // When
        int score = scoreProcessor.computeScore(world, newArrayList(drone));

        // Then
        assertThat(score).isEqualTo(64);
    }

}
