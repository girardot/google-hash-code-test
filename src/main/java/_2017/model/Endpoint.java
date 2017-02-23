package _2017.model;

import java.util.List;

public class Endpoint {

    public int latencyWithDataCenter;

    public List<Integer> latencyWithCaches;

    public List<Integer> requestsPerVideo;
    public int cacheCount;


    @Override
    public String toString() {
        return "Endpoint{" +
                "latencyWithDataCenter=" + latencyWithDataCenter +
                ", latencyWithCaches=" + latencyWithCaches +
                ", requestsPerVideo=" + requestsPerVideo +
                '}';
    }
}