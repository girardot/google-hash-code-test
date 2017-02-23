package _2017;

import _2017.model.Requests;

import java.util.Comparator;

public class ThirdRequestsComparator implements Comparator<Requests> {
    @Override
    public int compare(Requests o1, Requests o2) {
        final int reduce1 = o1.endPoint.latencyWithCaches.size();
        final int reduce2 = o2.endPoint.latencyWithCaches.size();
        return -(reduce2 - reduce1);
    }
}
