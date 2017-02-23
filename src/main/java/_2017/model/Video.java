package _2017.model;

public class Video {

    public int size;

    public Video(int size) {

        this.size = size;
    }

    public Video() {
    }

    @Override
    public String toString() {
        return "Video{" +
                "size=" + size +
                '}';
    }
}
