package de.dktk.dd.rpb.uploaderbasicwebservice.util;

import de.dktk.dd.rpb.uploaderbasicwebservices.util.Counter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CounterTest {
    Counter counter;

    @Before
    public void beforeEach() throws Exception {
        counter = new Counter();
    }

    @Test
    public void testCount() {
        counter.addUID("2.25.5678", 18);
        assertEquals(18, counter.getCount("2.25.5678"));
        assertNotEquals(19, counter.getCount("2.25.5678"));
    }

    @Test
    public void testHasUID() {
        assertFalse(counter.hasUID("2.25.5678"));

        counter.addUID("2.25.5678", 1);
        assertTrue(counter.hasUID("2.25.5678"));
    }
}
