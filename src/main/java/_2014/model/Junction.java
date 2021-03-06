package _2014.model;

import java.util.ArrayList;
import java.util.List;

public class Junction {

    public final int index;

    public final double longitute, latitute;

    public List<Street> streets = new ArrayList<>();

    public Junction(int index, double longitute, double latitute) {
        this.index = index;
        this.longitute = longitute;
        this.latitute = latitute;
    }

    @Override
    public String toString() {
        return "Junction{" +
                "longitute=" + longitute +
                ", latitute=" + latitute +
                '}';
    }
}
