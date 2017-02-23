package _2017;

import _2017.model.Requests;

import java.util.Comparator;

public class ThirdRequestsComparator implements Comparator<Requests> {
    @Override
    public int compare(Requests o1, Requests o2) {
        return o1.count * o1.video.size - o2.count * o2.video.size;
    }
}
