package _2016.process;

import _2016.model.Drone;
import _2016.model.Order;
import _2016.model.OrderItem;
import _2016.model.World;
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
        int dropNumber = drones.size();
        for (Order order : world.orders) {
            System.out.println("order = " + order);
            for (OrderItem item : order.expecteditems) {
                System.out.println(item.toString());
                Drone currentDrone;
                while (true) {
                    currentDrone = drones.get(droneId % dropNumber);
                    if (currentDrone.canFly()) {
                        break;
                    } else {
                        droneId++;
                    }
                }
                Drone drone = currentDrone;
                //Drone drone = nextAvalableDrone(drones, droneId, dropNumber);
                drone.load(item.type, item.count, world.warehouses.get(0));
                drone.deliver(item.type, item.count, order);
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
