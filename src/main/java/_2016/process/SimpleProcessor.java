package _2016.process;

import _2016.model.Drone;
import _2016.model.World;

import java.util.List;
import java.util.stream.Collectors;

import static _2016.model.Instruction.buildDeliverInstruction;
import static _2016.model.Instruction.buildLoadInstruction;
import static java.util.stream.IntStream.range;

public class SimpleProcessor implements Processor {

    @Override
    public List<Drone> process(World world) {

        List<Drone> drones = range(0, world.drones)
                .mapToObj(Drone::new)
                .collect(Collectors.toList());

        // Sample make 194 score for simple.in
        Drone drone1 = drones.get(0);
        drone1.instructions.add(buildLoadInstruction(world.warehouses.get(0), 0, 1));
        drone1.instructions.add(buildLoadInstruction(world.warehouses.get(0), 1, 1));
        drone1.instructions.add(buildDeliverInstruction(world.orders.get(0), 0, 1));
        drone1.instructions.add(buildLoadInstruction(world.warehouses.get(1), 2, 1));
        drone1.instructions.add(buildDeliverInstruction(world.orders.get(0), 2, 1));

        Drone drone2 = drones.get(1);
        drone2.instructions.add(buildLoadInstruction(world.warehouses.get(1), 2, 1));
        drone2.instructions.add(buildDeliverInstruction(world.orders.get(2), 2, 1));
        drone2.instructions.add(buildLoadInstruction(world.warehouses.get(0), 0, 1));
        drone2.instructions.add(buildDeliverInstruction(world.orders.get(1), 0, 1));
        return drones;
    }
}
