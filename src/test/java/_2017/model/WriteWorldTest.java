package _2017.model;

import org.junit.Test;

import java.io.IOException;

public class WriteWorldTest {

    @Test
    public void write_test() throws IOException {
        // Given
        final World world = new World();
        final Cache c1 = new Cache(20);
        c1.videos.add(2);
        c1.videos.add(5);

        world.caches.add(c1);

        final Cache c2 = new Cache(20);
        world.caches.add(c2);


        final Cache c3 = new Cache(20);
        c3.videos.add(9);
        c3.videos.add(4);

        world.caches.add(c3);

        // When
        world.write("test.out");

        //Then

    }
}