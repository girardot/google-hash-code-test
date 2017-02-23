package _2017;

import _2017.input.InputReader;
import _2017.model.World;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader();
        //String[] fileNames = {"kittens.in", "me_at_the_zoo.in", "trending_today.in", "videos_worth_spreading.in"};
        String[] fileNames = {"kittens.in"};

        final Processor processor = new SimpleProcessor();
        for (String fileName : fileNames) {
            World world = inputReader.parse("/" + fileName);
            processor.process(world);
            world.write(fileName.replace(".in", ".out"));
        }

    }

}
