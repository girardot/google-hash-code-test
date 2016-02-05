package _2014.model;

public class Street {

    public final Junction first, second;

    public final int directional, time, length;

    public Street(Junction first, Junction second, int directional, int time, int length) {
        this.first = first;
        this.second = second;
        this.directional = directional;
        this.time = time;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Street{" +
                "first=" + first +
                ", second=" + second +
                ", directional=" + directional +
                ", time=" + time +
                ", length=" + length +
                '}';
    }
}
