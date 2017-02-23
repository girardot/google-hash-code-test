package _2017.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cache {

    public int size;

    public List<Integer> videos = new ArrayList<>();

    public int numberOfVideo() {
        return videos.size();
    }


    public String displayCache() {
        return videos.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(" "));
    }
}
