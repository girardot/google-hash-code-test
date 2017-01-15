package _2016.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void should_sort_positions_from_the_nearest_to_the_farthest_distance() {
        // Given
        Position initialPosition = new Position(0, 0);
        List<Position> positionsToOrder = new ArrayList<>();
        positionsToOrder.add(new Position(15, 15));
        positionsToOrder.add(new Position(3, 3));
        positionsToOrder.add(new Position(10, 10));

        // When
        positionsToOrder.sort(initialPosition.nearestPositionComparator());

        // Then
        assertThat(positionsToOrder).containsExactly(
                new Position(3, 3),
                new Position(10, 10),
                new Position(15, 15)
        );
    }
}