package _2017;

import _2017.model.Cache;
import _2017.model.Video;
import _2017.model.World;
import org.junit.Test;

import java.io.IOException;

public class SimpleProcessorTest {

    @Test
    public void process() throws IOException {
        // Given
        final SimpleProcessor simpleProcessor = new SimpleProcessor();
        final World world = new World();
        world.videos.add(new Video(10));
        world.videos.add(new Video(30));
        world.videos.add(new Video(20));

        world.caches.add(new Cache(20));
        world.caches.add(new Cache(20));

        // When
        simpleProcessor.process(world);
        //Then

        world.write("test.out");
    }
}