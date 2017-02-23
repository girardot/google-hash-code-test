package _2017.input;

import _2017.model.Video;
import _2017.model.World;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class InputReader {

    public World parse(String fileName) throws FileNotFoundException {

        try (Stream<String> lines = Files.lines(Paths.get(InputReader.class.getResource("/" + fileName).toURI()))) {

            List<String> collectedLines = lines.collect(Collectors.toList());
            int[] split = splitToInt(collectedLines.get(0));
            int videoCount = split[0];

            World world = new World();

            world.videos = parseVideo(videoCount, collectedLines.get(1));
            return world;

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int[] splitToInt(String line) {
        return Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private List<Video> parseVideo(int videoCount, String videoLines) {
        int[] videoSize = splitToInt(videoLines);
        return IntStream.range(0, videoCount)
                .mapToObj(index -> new Video(videoSize[index]))
                .collect(Collectors.toList());
    }


}
