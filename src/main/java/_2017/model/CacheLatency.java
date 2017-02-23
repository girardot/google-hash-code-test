package _2017.model;

import com.google.common.base.MoreObjects;

public class CacheLatency {

    public int id;
    public int latency;


    public CacheLatency(int id, int latency) {

        this.id = id;
        this.latency = latency;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("latency", latency)
                .toString();
    }
}
