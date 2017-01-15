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

    @Test
    public void should_not_move() {
        // Given
        Position startPosition = new Position(1, 1);
        Position destination = new Position(1, 1);

        // When
        Position newPosition = startPosition.moveToDestination(destination);

        // Then
        assertThat(newPosition).isEqualTo(startPosition);
    }

    @Test
    public void should_move_right() {
        // Given
        Position startPosition = new Position(1, 1);
        Position destination = new Position(6, 1);

        // When
        Position newPosition = startPosition.moveToDestination(destination);

        // Then
        assertThat(newPosition).isEqualTo(new Position(2, 1));
    }

    @Test
    public void should_move_left() {
        // Given
        Position startPosition = new Position(6, 1);
        Position destination = new Position(1, 1);

        // When
        Position newPosition = startPosition.moveToDestination(destination);

        // Then
        assertThat(newPosition).isEqualTo(new Position(5, 1));
    }

    @Test
    public void should_move_up() {
        // Given
        Position startPosition = new Position(5, 4);
        Position destination = new Position(5, 1);

        // When
        Position newPosition = startPosition.moveToDestination(destination);

        // Then
        assertThat(newPosition).isEqualTo(new Position(5, 3));
    }

    @Test
    public void should_move_down() {
        // Given
        Position startPosition = new Position(5, 1);
        Position destination = new Position(5, 4);

        // When
        Position newPosition = startPosition.moveToDestination(destination);

        // Then
        assertThat(newPosition).isEqualTo(new Position(5, 2));
    }

}