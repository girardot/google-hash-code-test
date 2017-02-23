package _2017;

import _2017.input.InputReader;
import _2017.model.World;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ZipException {
        InputReader inputReader = new InputReader();
        String[] fileNames = {"kittens.in", "me_at_the_zoo.in", "trending_today.in", "videos_worth_spreading.in"};
        //String[] fileNames = {"kittens.in"};

        final Processor processor = new ThirdProcessor();
        for (String fileName : fileNames) {
            World world = inputReader.parse(fileName);
            processor.process(world);
            world.write(fileName.replace(".in", ".out"));
            int score = world.computeScore();
            System.out.println(fileName+" score "+score);
        }

        File file = new File("project.zip");
        file.delete();
        ZipFile zipFile = new ZipFile(file);
        zipFile.addFolder("src", new ZipParameters());
        zipFile.addFile(new File("pom.xml"), new ZipParameters());

    }

}
