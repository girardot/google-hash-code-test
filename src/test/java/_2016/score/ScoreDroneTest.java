package _2016.score;


import _2016.model.Position;
import _2016.model.Warehouse;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static _2016.model.Instruction.buildLoadInstruction;
import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoreDroneTest {

    private final Warehouse wareHouse = new Warehouse(0, new Position(0, 0), new ArrayList<>());

    @Test
    public void should_load_items() {
        // Given
        ScoreDrone scoreDrone = new ScoreDrone(0, new ArrayList<>(), 100, newArrayList(10, 20, 30));

        // When
        scoreDrone.load(buildLoadInstruction(wareHouse, 2, 1));

        //Then
        assertThat(scoreDrone.getItemsCarried()).hasSize(1);
    }

    @Test
    public void should_not_load_items_when_is_too_heavy() {
        // Given
        ScoreDrone scoreDrone = new ScoreDrone(0, new ArrayList<>(), 100, newArrayList(10, 20, 30));

        // When
        scoreDrone.load(buildLoadInstruction(wareHouse, 2, 4));

        //Then
        assertThat(scoreDrone.getItemsCarried()).isEmpty();
    }

    @Test
    public void should_not_load_items_when_total_caried_is_to_heavy() {
        // Given
        ScoreDrone scoreDrone = new ScoreDrone(0, new ArrayList<>(), 100, newArrayList(10, 20, 30));
        scoreDrone.load(buildLoadInstruction(wareHouse, 0, 8));
        assertThat(scoreDrone.getItemsCarried().get(0)).isEqualTo(8);
        assertThat(scoreDrone.getItemsCarried()).hasSize(1);

        // When
        scoreDrone.load(buildLoadInstruction(wareHouse, 2, 1));

        //Then
        assertThat(scoreDrone.getItemsCarried()).hasSize(1);
        assertThat(scoreDrone.getItemsCarried().get(2)).isNull();
    }

    @Ignore
    @Test
    public void should_deliver_only_loaded_items() {
        //TODO
    }
}