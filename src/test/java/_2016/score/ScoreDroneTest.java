package _2016.score;


import _2016.model.Order;
import _2016.model.OrderItem;
import _2016.model.Position;
import _2016.model.Warehouse;
import org.junit.Test;

import java.util.ArrayList;

import static _2016.model.Instruction.buildDeliverInstruction;
import static _2016.model.Instruction.buildLoadInstruction;
import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoreDroneTest {

    private final Warehouse wareHouse = new Warehouse(0, new Position(0, 0), new ArrayList<>());
    final int PRODUCT_TYPE = 0;
    private final int OTHER_PRODUCT_TYPE = 2;

    @Test
    public void should_load_items() {
        // Given
        ScoreDrone scoreDrone = new ScoreDrone(0, new ArrayList<>(), 100, newArrayList(10, 20, 30));

        // When
        scoreDrone.load(buildLoadInstruction(wareHouse, OTHER_PRODUCT_TYPE, 1));

        //Then
        assertThat(scoreDrone.getItemsCarried()).hasSize(1);
    }

    @Test
    public void should_not_load_items_when_is_too_heavy() {
        // Given
        ScoreDrone scoreDrone = new ScoreDrone(0, new ArrayList<>(), 100, newArrayList(10, 20, 30));

        // When
        scoreDrone.load(buildLoadInstruction(wareHouse, OTHER_PRODUCT_TYPE, 4));

        //Then
        assertThat(scoreDrone.getItemsCarried()).isEmpty();
    }

    @Test
    public void should_not_load_items_when_total_carried_is_to_heavy() {
        // Given
        ScoreDrone scoreDrone = new ScoreDrone(0, new ArrayList<>(), 100, newArrayList(10, 20, 30));
        scoreDrone.load(buildLoadInstruction(wareHouse, PRODUCT_TYPE, 8));
        assertThat(scoreDrone.getItemsCarried().get(PRODUCT_TYPE)).isEqualTo(8);
        assertThat(scoreDrone.getItemsCarried()).hasSize(1);

        // When
        scoreDrone.load(buildLoadInstruction(wareHouse, OTHER_PRODUCT_TYPE, 1));

        //Then
        assertThat(scoreDrone.getItemsCarried()).hasSize(1);
        assertThat(scoreDrone.getItemsCarried().get(OTHER_PRODUCT_TYPE)).isNull();
    }

    @Test
    public void should_deliver_loaded_items() {
        // Given
        ScoreDrone scoreDrone = new ScoreDrone(0, new ArrayList<>(), 100, newArrayList(10, 20, 30));
        scoreDrone.load(buildLoadInstruction(wareHouse, PRODUCT_TYPE, 8));
        assertThat(scoreDrone.getItemsCarried().get(PRODUCT_TYPE)).isEqualTo(8);
        assertThat(scoreDrone.getItemsCarried()).hasSize(1);

        // When
        scoreDrone.deliver(buildDeliverInstruction(
                new Order(0, new Position(1, 1), newArrayList(new OrderItem(PRODUCT_TYPE, 2))),
                PRODUCT_TYPE,
                2
        ));

        //Then
        assertThat(scoreDrone.getItemsCarried().get(PRODUCT_TYPE)).isEqualTo(6);
        assertThat(scoreDrone.getItemsCarried()).hasSize(1);
    }

    @Test
    public void deliver_only_loaded_items() {
        // Given
        ScoreDrone scoreDrone = new ScoreDrone(0, new ArrayList<>(), 100, newArrayList(10, 20, 30));
        scoreDrone.load(buildLoadInstruction(wareHouse, PRODUCT_TYPE, 8));
        assertThat(scoreDrone.getItemsCarried().get(PRODUCT_TYPE)).isEqualTo(8);
        assertThat(scoreDrone.getItemsCarried().get(OTHER_PRODUCT_TYPE)).isNull();
        assertThat(scoreDrone.getItemsCarried()).hasSize(1);

        // When
        scoreDrone.deliver(buildDeliverInstruction(
                new Order(0, new Position(1, 1), newArrayList(new OrderItem(OTHER_PRODUCT_TYPE, 3))),
                OTHER_PRODUCT_TYPE,
                3
        ));

        //Then
        assertThat(scoreDrone.getItemsCarried().get(PRODUCT_TYPE)).isEqualTo(8);
        assertThat(scoreDrone.getItemsCarried().get(OTHER_PRODUCT_TYPE)).isNull();
        assertThat(scoreDrone.getItemsCarried()).hasSize(1);
    }

}