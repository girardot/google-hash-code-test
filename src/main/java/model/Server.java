package model;

public class Server {

    public final int size, capacity;

    public Server(int size, int capacity) {
        this.size = size;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Server{" +
                "size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
