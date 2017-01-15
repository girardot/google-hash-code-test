package _2016.score;

import _2016.model.*;

import java.util.Iterator;
import java.util.List;

import static _2016.model.InstructionType.DELIVER;
import static _2016.model.InstructionType.LOAD;

public class ScoreProcessor {

    public int computeScore(World world, List<Drone> drones) {
        int score = 0;
        Position firstDronePosition = new Position(2, 2);
        Drone firstDrone = drones.get(0);
        List<Instruction> instructions = firstDrone.instructions;
        Iterator<Instruction> instructionIterator = instructions.iterator();

        Instruction droneInstruction = instructionIterator.next();
        System.out.println("Drone instruction is : " + droneInstruction);

        for (int turn = 0; turn < world.turns; turn++) {
            System.out.println("***************** Turn : " + turn + " *****************");

            if (LOAD.equals(droneInstruction.instructionType)) {
                final Position destination = droneInstruction.wareHouse.position;

                int distanceToWarehouse = firstDronePosition.distance(destination);
                if (distanceToWarehouse != 0) {
                    System.out.print("Drone " + firstDronePosition + " is moving to warehouse" + destination);
                    firstDronePosition = firstDronePosition.moveToDestination(destination);
                    System.out.println(" -----> new drone position is  " + firstDronePosition);

                } else {
                    System.out.println("Drone is loading");
                    if (instructionIterator.hasNext()) {
                        droneInstruction = instructionIterator.next();
                        System.out.println("Drone instruction is : " + droneInstruction);
                    }
                }

            } else if (DELIVER.equals(droneInstruction.instructionType)) {
                final Position destination = droneInstruction.order.destination;

                int distanceToClient = firstDronePosition.distance(destination);
                if (distanceToClient != 0) {
                    System.out.print("Drone " + firstDronePosition + " is moving to client" + destination);
                    firstDronePosition = firstDronePosition.moveToDestination(destination);
                    System.out.println(" -----> new drone position is  " + firstDronePosition);
                } else {
                    System.out.println("Drone is deliver");
                    if (instructionIterator.hasNext()) {
                        droneInstruction = instructionIterator.next();
                        System.out.println("Drone instruction is : " + droneInstruction);
                    }

                    for (Order order : world.orders) {
                        if (order.equals(droneInstruction.order)) {
                            for (OrderItem item : order.expectedItems) {
                                if (item.type == droneInstruction.productType) {
                                    item.isDone = true;
                                }
                            }
                            if (order.expectedItems.stream().allMatch(i -> i.isDone)) {
                                score += 100 * (world.turns - turn) / world.turns;
                            }
                        }
                    }
                }

            }
        }

        return score;
    }

}
