package _2014.model;

import com.google.common.collect.Lists;

import java.util.List;

public class Car {

    public int timer;

    public final List<Junction> junctions = Lists.newArrayList();

    public Car(int timer) {
        this.timer = timer;
    }

    public void browse(Street street) {
        junctions.add(street.second);
        timer -= street.time;
    }

}
