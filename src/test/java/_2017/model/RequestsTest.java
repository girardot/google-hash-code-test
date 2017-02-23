package _2017.model;

import org.junit.Test;

public class RequestsTest {

    @Test
    public void testName() {
        // Given

        // When
        final Requests r = new Requests();
        r.count = 15;
        final Requests r2 = new Requests();
        r2.count = 20;
        r.compareTo(r2);
        //Then


    }
}