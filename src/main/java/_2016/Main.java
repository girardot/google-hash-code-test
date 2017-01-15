package _2016;

import _2016.input.InputReader;
import _2016.model.Drone;
import _2016.model.World;
import _2016.output.Writer;
import _2016.process.SimpleProcessor;
import _2016.score.ScoreProcessor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ScoreProcessor scoreProcessor = new ScoreProcessor();
        InputReader inputReader = new InputReader();
        String[] fileNames = {"busy_day.in", "redundancy.in", "mother_of_all_warehouses.in"};

        for (String fileName : fileNames) {
            System.out.println("File " + fileName + " loading");
            World world = inputReader.parse("/" + fileName);

            System.out.println("World Processing");
            SimpleProcessor simpleProcessor = new SimpleProcessor();
            List<Drone> drones = simpleProcessor.process(world);

            System.out.println("Score => " + scoreProcessor.computeScore(world, drones));

            System.out.println("Result writing");
            Writer writer = new Writer();
            writer.write(drones, new FileWriter(new File("output_" + fileName)));
        }

    }

}
