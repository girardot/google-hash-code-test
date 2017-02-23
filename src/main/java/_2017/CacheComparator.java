package _2017;

import _2017.model.CacheLatency;

import java.util.Comparator;

public class CacheComparator implements Comparator<CacheLatency> {
    private int latencyWithDataCenter;

    public CacheComparator(int latencyWithDataCenter) {

        this.latencyWithDataCenter = latencyWithDataCenter;
    }

    @Override
    public int compare(CacheLatency o1, CacheLatency o2) {

        final int gain1 = latencyWithDataCenter - o1.latency;
        final int gain2 = latencyWithDataCenter - o2.latency;
        return gain2 - gain1;
    }
}
