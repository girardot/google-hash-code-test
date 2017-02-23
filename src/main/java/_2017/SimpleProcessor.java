package _2017;

import _2017.model.Cache;
import _2017.model.Video;
import _2017.model.World;

public class SimpleProcessor implements Processor {

    @Override
    public void process(World world) {
        for (Video video : world.videos) {
            for (Cache cache : world.caches) {
                final boolean b = cache.addVideo(world.videos.indexOf(video), video);
                if (b) {
                    break;
                }

            }
        }

    }

}
