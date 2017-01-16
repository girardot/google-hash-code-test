package _2016.score;

import _2016.model.*;

import java.util.List;
import java.util.stream.Collectors;

import static _2016.model.InstructionType.DELIVER;
import static _2016.model.InstructionType.LOAD;

public class ScoreProcessor {

    public int computeScore(World world, List<Drone> drones) {
        int score = 0;
        final List<ScoreDrone> scoreDrones = drones.stream()
                .map(d -> new ScoreDrone(d.index, d.instructions, world.maxPayLoad))
                .collect(Collectors.toList());

        for (int turn = 0; turn < world.turns; turn++) {
            System.out.println("\n***************** Turn : " + turn + " *****************");

            for (ScoreDrone drone : scoreDrones) {
                System.out.println("xxxxxxxxxxxxxxxxxxxx Drone: " + drone.index + " xxxxxxxxxxxxxxxxxxxx");

                if (drone.getCurrentInstruction() == null) {
                    System.out.println("Drone(" + drone.index + ") do not have instruction");
                } else {
                    System.out.println("Drone(" + drone.index + ") instruction is : " + drone.getCurrentInstruction());
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
                        System.out.println("Drone(" + drone.index + ") new instruction is : " + nextInstruction);
                    }
                }
            }
        }

        return score;
    }

}
