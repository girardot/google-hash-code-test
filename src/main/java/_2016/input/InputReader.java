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

import static java.lang.Integer.parseInt;

public class InputReader {

    public World parse(String fileName) throws FileNotFoundException {

        try (Stream<String> lines = Files.lines(Paths.get(InputReader.class.getResource(fileName).toURI()))) {

            List<String> collectedLines = lines.collect(Collectors.toList());

            World world = initWorld(collectedLines.get(0));

            world.productTypeWeigh = retrieveProductTypeWeigh(collectedLines);


            return world;

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int[] retrieveProductTypeWeigh(List<String> collectedLines) {
        String productTypeWeighLine = collectedLines.get(2);
        String[] weighAsString = productTypeWeighLine.split(" ");

        return Stream.of(weighAsString)
                .map(value -> Integer.parseInt(value))
                .mapToInt(i ->i)
                .toArray();
    }

    private World initWorld(String line) {

        Pattern pattern = Pattern.compile("(\\d+) (\\d+) (\\d+) (\\d+) (\\d+)");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            return new World(parseInt(matcher.group(1)), parseInt(matcher.group(2)), parseInt(matcher.group(3)), parseInt(matcher.group(4)), parseInt(matcher.group(5)));
        }

        throw new IllegalArgumentException("unknow format " + line);
    }


}
