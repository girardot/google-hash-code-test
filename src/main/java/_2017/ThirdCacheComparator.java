package _2017;

import _2017.model.CacheLatency;
import _2017.model.Video;

import java.util.Comparator;

public class ThirdCacheComparator implements Comparator<CacheLatency> {
    private Video video;
    private int latencyWithDataCenter;

    public ThirdCacheComparator(Video video, int latencyWithDataCenter) {
        this.video = video;
        this.latencyWithDataCenter = latencyWithDataCenter;
    }

    @Override
    public int compare(CacheLatency o1, CacheLatency o2) {

        final int gain1 = latencyWithDataCenter - o1.latency;
        final int gain2 = latencyWithDataCenter - o2.latency;
        return gain2 - gain1;
    }
}
