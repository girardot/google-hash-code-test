package _2017.model;

import java.util.ArrayList;
import java.util.List;

public class Endpoint {

    public int latencyWithDataCenter;

    public List<CacheLatency> latencyWithCaches = new ArrayList<>();

    public int cacheCount;


    @Override
    public String toString() {
        return "Endpoint{" +
                "latencyWithDataCenter=" + latencyWithDataCenter +
                ", latencyWithCaches=" + latencyWithCaches +
                '}';
    }
}
