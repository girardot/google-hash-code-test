package _2017.input;

import _2017.model.Endpoint;
import _2017.model.Pair;
import _2017.model.Video;
import _2017.model.World;
import com.google.common.collect.ImmutableMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
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
            int endPointCount = split[1];
            int requestCount = split[2];
            int cacheCount = split[3];

            World world = new World();

            world.videos = parseVideo(videoCount, collectedLines.get(1));
            Pair<Integer, List<Endpoint>> result = parseEndPoints(endPointCount, collectedLines, cacheCount);
            world.endPoints = result._2;
            return world;

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Pair<Integer, List<Endpoint>> parseEndPoints(int endPointCount, List<String> collectedLines, int cacheCount) {
        List<Endpoint> endpoints = new ArrayList<>();
        int indexInFile = 2;
        for (int i = 0; i < endPointCount; i++) {
            Endpoint endpoint = new Endpoint();
            int[] latencyWithDataCenter = splitToInt(collectedLines.get(indexInFile++));
            endpoint.latencyWithDataCenter = latencyWithDataCenter[0];
            endpoint.cacheCount = latencyWithDataCenter[1];

            endpoint.latencyWithCaches = IntStream.range(0, cacheCount)
                    .mapToObj(a -> -1).collect(Collectors.toList());
            for (int j = 0; j < endpoint.cacheCount; j++) {

                int[] cacheConf = splitToInt(collectedLines.get(indexInFile++));
                endpoint.latencyWithCaches.set(cacheConf[0], cacheConf[1]);
            }

            endpoints.add(endpoint);

        }
        return new Pair<>(indexInFile, endpoints);
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
