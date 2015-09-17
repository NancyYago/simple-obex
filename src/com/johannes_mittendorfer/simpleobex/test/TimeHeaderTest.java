package com.johannes_mittendorfer.simpleobex.test;

import com.johannes_mittendorfer.simpleobex.header.TimeHeader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.GregorianCalendar;

public class TimeHeaderTest extends HeaderTest {

    private TimeHeader h;

    @Before
    public void init(){
        GregorianCalendar d = new GregorianCalendar(2012, 7, 24,13,5,58);
        h = new TimeHeader(d.getTime());
    }

    @Test
    public void testGenerate(){
        byte[] expected = TestUtil.hexStringToByteArray("440012323031323038323454313130353538");
        byte[] actual = h.getBytes();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetLength(){
        Assert.assertEquals(18, h.getLength());
    }

    @Test
    public void testToString(){
        Assert.assertEquals("Time: Fri Aug 24 13:05:58 CEST 2012", h.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateNull(){
        new TimeHeader(null);
    }

    @Test
    public void testParse() throws UnsupportedEncodingException {
        Assert.fail();
    }
}
