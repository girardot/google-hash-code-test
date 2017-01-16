package _2016.score;

import _2016.model.*;

import java.util.Iterator;
import java.util.List;

import static _2016.model.InstructionType.DELIVER;
import static _2016.model.InstructionType.LOAD;

public class ScoreProcessor {

    public int computeScore(World world, List<Drone> drones) {
        int score = 0;
        ScoreDrone drone = new ScoreDrone(drones.get(0).instructions);

        System.out.println("Drone instruction is : " + drone.currentInstruction);

        for (int turn = 0; turn < world.turns; turn++) {
            System.out.println("***************** Turn : " + turn + " *****************");
            Position instructionDestination = getDestinationFrom(drone.getCurrentInstruction());

            boolean hasMove = drone.moveTo(instructionDestination, drone.getCurrentInstruction().instructionType);
            if (!hasMove) {
                if (LOAD.equals(drone.getCurrentInstruction().instructionType)) {
                    drone.load(drone.getCurrentInstruction());
                } else if (DELIVER.equals(drone.getCurrentInstruction().instructionType)) {
                    drone.deliver(drone.getCurrentInstruction());

                    for (Order order : world.orders) {
                        if (order.equals(drone.getCurrentInstruction().order)) {
                            for (OrderItem item : order.expectedItems) {
                                if (item.type == drone.getCurrentInstruction().productType) {
                                    item.isDone = true;
                                }
                            }
                            if (order.expectedItems.stream().allMatch(i -> i.isDone)) {
                                score += 100 * (world.turns - turn) / world.turns;
                            }
                        }
                    }
                }
                Instruction nextInstruction = drone.getNextInstruction();
                if (nextInstruction == null) {
                    break;
                }
                System.out.println("Drone new instruction is : " + nextInstruction);
            }
        }

        return score;
    }

    private Position getDestinationFrom(Instruction instruction) {
        Position destination = null;
        if (LOAD.equals(instruction.instructionType)) {
            destination = instruction.wareHouse.position;
        } else if (DELIVER.equals(instruction.instructionType)) {
            destination = instruction.order.destination;
        }
        return destination;
    }

    private class ScoreDrone {
        private Position position = new Position(0, 0);
        private final Iterator<Instruction> instructionIterator;
        private Instruction currentInstruction;

        private ScoreDrone(List<Instruction> instructions) {
            instructionIterator = instructions.iterator();
            getNextInstruction();
        }

        public Instruction getNextInstruction() {
            currentInstruction = null;
            if (instructionIterator.hasNext()) {
                currentInstruction = instructionIterator.next();
            }
            return currentInstruction;
        }

        public Instruction getCurrentInstruction() {
            return currentInstruction;
        }

        private boolean moveTo(Position destination, InstructionType instructionType) {
            int distanceToDestination = position.distance(destination);
            boolean hasMove = false;
            if (distanceToDestination != 0) {
                System.out.print("Drone " + position + " is moving to " + (LOAD.equals(instructionType) ? "warehouse" : "client") + destination);
                position = position.moveToDestination(destination);
                System.out.println(" -----> new drone position is  " + position);
                hasMove = true;
            }
            return hasMove;
        }

        public void load(Instruction instruction) {
            System.out.println("Drone is loading item " + instruction.productType + " from warehouse " + instruction.wareHouse.index);
        }

        public void deliver(Instruction instruction) {
            System.out.println("Drone is deliver item " + instruction.productType + " to order " + instruction.order.index);
        }
    }

}
