package _2016.model;

import java.util.Comparator;
import java.util.Objects;

import static java.lang.Math.*;

public class Position {

    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Comparator<Position> nearestPositionComparator() {
        Position current = this;
        return (o1, o2) -> {
            Integer distanceO1 = o1.distance(current);
            Integer distanceO2 = o2.distance(current);
            return distanceO1.compareTo(distanceO2);
        };
    }

    private int distance(Position position) {
        return (int) ceil(sqrt(pow(position.x - this.x, 2) + pow(position.y - this.y, 2)));
    }
}
