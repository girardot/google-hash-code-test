package _2017;

import _2017.model.CacheLatency;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CacheComparatorTest {
    @Test
    public void testName() {
        // Given
        List<CacheLatency> caches = new ArrayList<>();

        final CacheLatency c1 = new CacheLatency(1, 600);
        final CacheLatency c2 = new CacheLatency(2, 500);
        caches.add(c1);
        caches.add(c2);

        final CacheComparator cacheComparator = new CacheComparator(1000);
        // When
        Collections.sort(caches, cacheComparator);

        //Then
        System.out.println(caches.get(0));
    }
}