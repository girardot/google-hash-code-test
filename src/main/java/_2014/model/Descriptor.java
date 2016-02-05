package _2014.model;

public class Descriptor {

    public final int junctions, streets, seconds, cars, starting;

    public Descriptor(int junctions, int streets, int seconds, int cars, int starting) {
        this.junctions = junctions;
        this.streets = streets;
        this.seconds = seconds;
        this.cars = cars;
        this.starting = starting;
    }

    @Override
    public String toString() {
        return "Descriptor{" +
                "junctions=" + junctions +
                ", streets=" + streets +
                ", seconds=" + seconds +
                ", cars=" + cars +
                ", starting=" + starting +
                '}';
    }
}
