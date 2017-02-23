package _2017.model;

import com.google.common.base.MoreObjects;

public class Requests implements Comparable<Requests> {
    public int count;
    public int videoId;
    public int endPointId;
    public Endpoint endPoint;
    public Video video;


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("count", count)
                .add("videoId", videoId)
                .add("endPointId", endPointId)
                .add("endPoint", endPoint)
                .add("video", video)
                .toString();
    }

    @Override
    public int compareTo(Requests o) {
        return count - o.count;
    }
}
