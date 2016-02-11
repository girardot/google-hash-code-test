package _2016.process;

import _2016.model.*;
import com.google.common.collect.Lists;

import java.util.List;

public class SimpleProcessor implements Processor {

    @Override
    public List<Drone> process(World world) {

        List<Drone> drones = Lists.newArrayList();
        for (int i = 0; i < world.drones; i++) {
            drones.add(new Drone(i, world.turns, world.warehouses.get(0).position));
        }

        int droneId = 0;
        int droneNumber = drones.size();
        for (Order order : world.orders) {
            System.out.println("order = " + order);
            for (OrderItem item : order.expecteditems) {
                System.out.println(item.toString());
                Drone currentDrone;
                while (true) {
                    currentDrone = drones.get(droneId % droneNumber);
                    if (currentDrone.canFly()) {
                        break;
                    } else {
                        droneId++;
                    }
                }
                Drone drone = currentDrone;
                Warehouse warehouse = world.nextWarehouse(item.type);
                if (warehouse != null) {
                    drone.load(item.type, item.count, warehouse);
                    drone.deliver(item.type, item.count, order);
                }

                droneId++;
            }
        }

        return drones;
    }

    private Drone nextAvalableDrone(List<Drone> drones, int droneId, int droneNumber) {
        if (droneId > droneNumber) {
            return null;
        }

        Drone drone = drones.get(droneId % droneNumber);
        if (drone.canFly()) {
            return drone;
        } else {
            nextAvalableDrone(drones, droneId + 1, droneNumber);
        }
        return drone;
    }


}
