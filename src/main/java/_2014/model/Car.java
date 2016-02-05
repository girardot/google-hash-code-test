package _2014.model;

import com.google.common.collect.Lists;

import java.util.List;

public class Car {

    public int timer;

    public final List<Junction> junctions = Lists.newArrayList();

    public Junction lastJunction;

    public Car(int timer, Junction startJunction) {
        this.timer = timer;
        this.lastJunction = startJunction;
        junctions.add(startJunction);
    }

    public boolean browse(Street street) {
        if (canBrowse(street)) {

            Junction junction = street.second;

            junctions.add(junction);
            lastJunction = junction;
            timer -= street.time;
            return true;
        }
        return false;
    }

    private boolean canBrowse(Street street) {
        if (timer >= street.time) {
            return true;
        }
        return false;
    }


}
