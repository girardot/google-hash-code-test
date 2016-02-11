package _2016.process;

import _2016.model.Drone;
import _2016.model.Item;
import _2016.model.Order;
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
            for (Item item : order.expecteditems) {
                System.out.println(item.toString());
                Drone drone = drones.get(droneId % dropNumber);
                drone.load(item.type, item.count, world.warehouses.get(0));
                drone.deliver(item.type, item.count, order);
                droneId++;
            }
        }

        return drones;
    }


}
