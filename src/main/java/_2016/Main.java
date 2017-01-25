package _2016;

import _2016.input.InputReader;
import _2016.model.Drone;
import _2016.model.Warehouse;
import _2016.model.World;
import _2016.output.Writer;
import _2016.process.SimpleProcessor;
import _2016.score.ScoreProcessor;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class Main {
    public static final Logger LOGGER = getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        ScoreProcessor scoreProcessor = new ScoreProcessor();
        InputReader inputReader = new InputReader();
        // For training
        String[] fileNames = {"simple.in"};
//        String[] fileNames = {"busy_day.in", "redundancy.in", "mother_of_all_warehouses.in"};

        for (String fileName : fileNames) {
            LOGGER.info("File " + fileName + " loading");
            World world = inputReader.parse("/" + fileName);

            LOGGER.info("World Processing");
            SimpleProcessor simpleProcessor = new SimpleProcessor();

            List<Warehouse> warehousesCloned = clone(world.warehouses);

            List<Drone> drones = simpleProcessor.process(world);

            LOGGER.info("Score => " + scoreProcessor.computeScore(world, drones, warehousesCloned));

            LOGGER.info("Result writing");
            Writer writer = new Writer();
            writer.write(drones, new FileWriter(new File("output_" + fileName)));
        }

    }

    private static List<Warehouse> clone(List<Warehouse> warehouses) {
        List<Warehouse> listCloned = new ArrayList<>(warehouses.size());
        warehouses.forEach(warehouse -> listCloned.add(new Warehouse(warehouse.index, warehouse.position, warehouse.getItems())));
        return listCloned;
    }

}
