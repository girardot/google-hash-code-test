package _2016.input;

import _2016.model.Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputReader {

    public Model parse(String fileName) throws FileNotFoundException {

        try (Stream<String> lines = Files.lines(Paths.get(InputReader.class.getResource(fileName).toURI()))) {

            lines.forEach(System.out::println);

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
