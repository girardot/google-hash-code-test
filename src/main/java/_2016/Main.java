package _2016;

import _2016.input.InputReader;
import _2016.model.Drone;
import _2016.model.World;
import _2016.output.Writer;
import _2016.process.SimpleProcessor;

import java.io.IOException;
import java.util.List;

import static _2016.score.ScoreProcessor.computeScore;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader();
        String[] fileNames = {"busy_day.in", "redundancy.in", "mother_of_all_warehouses.in"};
        for (String fileName : fileNames) {
            World world = inputReader.parse("/" + fileName);
            System.out.println(world);

            SimpleProcessor simpleProcessor = new SimpleProcessor();

            List<Drone> drones = simpleProcessor.process(world);
            System.out.println("Score => " + computeScore(world, drones));
            Writer writer = new Writer();
            writer.write(drones, "output_" + fileName);
        }

    }

}
