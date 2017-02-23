package _2017.model;

import java.util.List;

public class World {

    public List<Video> videos;

    public List<Cache> caches;

    public List<Endpoint> endPoints;


    @Override
    public String toString() {
        return "World{" +
                "videos=" + videos +
                ", caches=" + caches +
                ", endPoints=" + endPoints +
                '}';
    }
}
