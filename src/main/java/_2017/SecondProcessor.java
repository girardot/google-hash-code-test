package _2017;

import _2017.model.*;

import java.util.Collections;

public class SecondProcessor implements Processor {

    @Override
    public void process(World world) {

        // sort request by cost
        Collections.sort(world.requests);

        for (Requests request : world.requests) {
            Collections.sort(request.endPoint.latencyWithCaches, new CacheComparator(request.endPoint.latencyWithDataCenter));
            Video video = request.video;
            for (CacheLatency latencyWithCache : request.endPoint.latencyWithCaches) {
                final Cache cache = world.caches.get(latencyWithCache.id);
                final boolean added = cache.addVideo(world.videos.indexOf(video), video);
                if (added) {
                    break;
                }

            }
        }
    }

}
