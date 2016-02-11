package _2016.input;

import _2016.model.World;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

    public World parse(String fileName) throws FileNotFoundException {

        try (Stream<String> lines = Files.lines(Paths.get(InputReader.class.getResource(fileName).toURI()))) {

            List<String> collectedLines = lines.collect(Collectors.toList());

            World world = initWorld(collectedLines.get(0));

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private World initWorld(String line) {
        World world = new World();

        Pattern pattern = Pattern.compile("(\\d) (\\d) (\\d) (\\d) (\\d)");
        Matcher matcher = pattern.matcher(line);


        return world;
    }

}
