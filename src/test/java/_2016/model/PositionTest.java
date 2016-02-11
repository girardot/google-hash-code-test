package _2016.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void should_compare_by_distance() {
        Position position1 = new Position(0, 0);
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(15, 15));
        positions.add(new Position(3, 3));
        positions.add(new Position(10, 10));


        positions.sort(position1.nearPositionComparator());


        assertThat(positions).containsExactly(new Position(3, 3), new Position(10, 10), new Position(15, 15));
    }
}