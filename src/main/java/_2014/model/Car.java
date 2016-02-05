package _2014.model;

import com.google.common.collect.Lists;

import java.util.List;

public class Car {

    public int timer;

    public final List<Junction> junctions = Lists.newArrayList();

    public Car(int timer) {
        this.timer = timer;
    }

    public boolean browse(Street street) {
        if (canBrowse(street)) {
            junctions.add(street.second);
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
