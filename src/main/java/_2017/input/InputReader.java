package _2017.input;

import _2017.model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputReader {

    public World parse(String fileName) throws FileNotFoundException {

        try (Stream<String> lines = Files.lines(Paths.get(InputReader.class.getResource("/" + fileName).toURI()))) {

            List<String> allLines = lines.collect(Collectors.toList());
            int[] firstLine = splitToInt(allLines.get(0));

            int videoCount = firstLine[0];
            int endPointCount = firstLine[1];
            int requestCount = firstLine[2];
            int cacheCount = firstLine[3];

            World world = new World();

            world.videos = parseVideo(videoCount, allLines.get(1));
            Pair<Integer, List<Endpoint>> result = parseEndPoints(endPointCount, allLines, cacheCount);
            world.endPoints = result._2;

            world.requests = parseRequests(world, result._1, requestCount, allLines);

            world.caches = parseCaches(cacheCount, firstLine[4]);
            return world;

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Requests> parseRequests(World world, Integer position, Integer requestCount, List<String> collectedLines) {

        List<Requests> requestsList = new ArrayList<>();
        for (int i = 0; i < requestCount; i++) {
            int[] requestParam = splitToInt(collectedLines.get(position++));

            Requests requests = new Requests();
            requests.count = requestParam[2];
            requests.videoId = requestParam[0];
            requests.endPointId = requestParam[1];

            requests.endPoint = world.findEndPoint(requests.endPointId);
            requests.video = world.findVideo(requests.videoId);

            requestsList.add(requests);
        }
        return requestsList;
    }

    private List<Cache> parseCaches(int cacheCount, int size) {
        return IntStream.range(0, cacheCount)
                .mapToObj(index -> new Cache(size))
                .collect(Collectors.toList());
    }

    private Pair<Integer, List<Endpoint>> parseEndPoints(int endPointCount, List<String> collectedLines, int cacheCount) {
        List<Endpoint> endpoints = new ArrayList<>();
        int indexInFile = 2;
        for (int i = 0; i < endPointCount; i++) {
            Endpoint endpoint = new Endpoint();
            int[] latencyWithDataCenter = splitToInt(collectedLines.get(indexInFile++));
            endpoint.latencyWithDataCenter = latencyWithDataCenter[0];
            endpoint.cacheCount = latencyWithDataCenter[1];

            for (int j = 0; j < endpoint.cacheCount; j++) {

                int[] cacheConf = splitToInt(collectedLines.get(indexInFile++));
                endpoint.latencyWithCaches.add(new CacheLatency(cacheConf[0], cacheConf[1]));

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
