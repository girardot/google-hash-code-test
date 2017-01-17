package _2016.score;

import _2016.model.*;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

import static _2016.model.InstructionType.DELIVER;
import static _2016.model.InstructionType.LOAD;
import static org.slf4j.LoggerFactory.getLogger;

public class ScoreProcessor {
    public final Logger LOGGER = getLogger(ScoreProcessor.class);

    public int computeScore(World world, List<Drone> drones) {
        int score = 0;
        final List<ScoreDrone> scoreDrones = drones.stream()
                .map(d -> new ScoreDrone(d.index, d.instructions, world.maxPayLoad, world.productTypeWeigh))
                .collect(Collectors.toList());

        for (int turn = 0; turn < world.turns; turn++) {

            LOGGER.debug("\n***************** Turn : " + turn + " *****************");

            for (ScoreDrone drone : scoreDrones) {
                LOGGER.debug("xxxxxxxxxxxxxxxxxxxx Drone: " + drone.index + " xxxxxxxxxxxxxxxxxxxx");

                if (drone.getCurrentInstruction() == null) {
                    LOGGER.debug("Drone(" + drone.index + ") do not have instruction");
                } else {
                    LOGGER.debug("Drone(" + drone.index + ") instruction is : " + drone.getCurrentInstruction());
                    Position instructionDestination = drone.getCurrentInstruction().getDestination();

                    boolean hasMove = drone.moveTo(instructionDestination, drone.getCurrentInstruction().instructionType);
                    if (!hasMove) {
                        if (LOAD.equals(drone.getCurrentInstruction().instructionType)) {
                            drone.load(drone.getCurrentInstruction());
                        } else if (DELIVER.equals(drone.getCurrentInstruction().instructionType)) {
                            drone.deliver(drone.getCurrentInstruction());

                            for (Order order : world.orders) {
                                if (order.equals(drone.getCurrentInstruction().order)) {
                                    order.expectedItems.stream()
                                            .filter(item -> item.type == drone.getCurrentInstruction().productType)
                                            .forEach(item -> item.isDone = true);

                                    if (order.expectedItems.stream().allMatch(i -> i.isDone)) {
                                        score += 100 * (world.turns - turn) / world.turns;
                                    }
                                }
                            }
                        }
                        Instruction nextInstruction = drone.getNextInstruction();
                        LOGGER.debug("Drone(" + drone.index + ") new instruction is : " + nextInstruction);
                    }
                }
            }
        }

        return score;
    }

}
