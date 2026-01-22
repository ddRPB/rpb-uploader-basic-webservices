package de.dktk.dd.rpb.uploaderbasicwebservice.util;

import de.dktk.dd.rpb.uploaderbasicwebservices.util.Counter;
import org.junit.Test;

import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void testCount() {
        Counter counter = new Counter();
        counter.addUID("2.25.5678", 18);
        assertEquals(counter.getCount("2.25.5678"), 18);
        assertFalse(counter.getCount("2.25.5678") == 19);
    }

    @Test
    public void testHasUID() {
        Counter counter = new Counter();
        assertFalse(counter.hasUID("2.25.5678"));

        counter.addUID("2.25.5678", 1);
        assertTrue(counter.hasUID("2.25.5678"));
    }
}
