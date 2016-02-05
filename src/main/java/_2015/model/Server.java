package _2015.model;

public class Server {

    public final int size, capacity, index;


    public Server(int size, int capacity, int index) {
        this.size = size;
        this.capacity = capacity;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Server{" +
                "size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
