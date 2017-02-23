package _2017.model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class World {

    public List<Video> videos = new ArrayList<>();

    public List<Cache> caches = new ArrayList<>();

    public List<Endpoint> endPoints = new ArrayList<>();

    public List<Requests> requests = new ArrayList<>();

    public void write(String outputName) throws IOException {
        final OutputStream outputStream = new FileOutputStream(outputName);

        final long count = caches.stream().filter(cache -> cache.numberOfVideo() > 0).count();
        outputStream.write((String.valueOf(count) + "\n").getBytes());
        caches.stream().filter(cache -> cache.numberOfVideo() > 0)
                .forEach((cache) -> {
                    try {
                        outputStream.write(
                                (caches.indexOf(cache) + " " + cache.displayCache() + "\n").getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        outputStream.close();
    }


    @Override
    public String toString() {
        return String.format("World{videos(%d)=%s,\n caches=%s, \n endPoints(%d)=%s, \nrequests (%d)=%s}" +
                "", videos.size(), videos, caches, endPoints.size(), endPoints, requests.size(), requests);
    }

    public Endpoint findEndPoint(int endPointId) {
        return endPoints.get(endPointId);
    }

    public Video findVideo(int videoId) {
        return videos.get(videoId);
    }

    public int computeScore() {
        int score = 0;
        for (Requests request : requests) {
            Integer idCache = findCache(request.videoId);
            int latency;
            if (idCache != null) {
                latency = request.endPoint.latencyWithCaches.stream()
                        .filter(cacheLatency -> cacheLatency.id == idCache)
                        .findFirst().get().latency;
            } else {
                latency = request.endPoint.latencyWithDataCenter;
            }
            score += request.count * latency;
        }
        return score;
    }

    private Integer findCache(int videoId) {
        for (int i = 0; i < caches.size(); i++) {
            Cache cach = caches.get(i);
            if (cach.videos.contains(videoId)) {
                return i;
            }
        }
        return null;
    }
}
