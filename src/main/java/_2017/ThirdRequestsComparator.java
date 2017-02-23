package _2017;

import _2017.model.Requests;

import java.util.Comparator;

public class ThirdRequestsComparator implements Comparator<Requests> {
    @Override
    public int compare(Requests o1, Requests o2) {
        final double factorSize = 0.8;
        return (int) ((o1.count + factorSize * o1.video.size) - (o2.count + factorSize * o2.video.size));
    }
}
