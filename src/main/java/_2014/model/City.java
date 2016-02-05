package _2014.model;

import java.util.List;

public class City {

    public final Descriptor descriptor;
    public final List<Junction> junctions;
    public final List<Street> streets;

    public City(Descriptor descriptor, List<Junction> junctions, List<Street> streets) {
        this.descriptor = descriptor;
        this.junctions = junctions;
        this.streets = streets;
    }

    @Override
    public String toString() {
        return "City{" +
                "descriptor=" + descriptor +
                ", junctions=" + junctions +
                ", streets=" + streets +
                '}';
    }

}
