package _2017.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cache {

    public final int size;

    public int remaining;

    public List<Integer> videos = new ArrayList<>();

    public Cache(int size) {
        this.size = size;
        this.remaining = size;
    }

    public int numberOfVideo() {
        return videos.size();
    }


    public String displayCache() {
        return videos.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(" "));
    }

    public boolean addVideo(int id, Video video) {
        if (remaining - video.size >= 0) {
            videos.add(id);
            remaining -= video.size;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cache{" +
                "size=" + size +
                ", remaining=" + remaining +
                ", videos=" + videos +
                '}';
    }
}
