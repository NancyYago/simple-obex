package com.johannes_mittendorfer.simpleobex.test;

import com.johannes_mittendorfer.simpleobex.header.NameHeader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class NameHeaderTest extends HeaderTest{

    NameHeader h;

    @Before
    public void init(){
        h = new NameHeader("telecom/pb.vcf");
    }

    @Test
    public void testGenerate(){
        byte[] expected = TestUtil.hexStringToByteArray("01002100740065006c00650063006f006d002f00700062002e0076006300660000");
        byte[] actual = h.getBytes();

        Assert.assertArrayEquals(expected, actual);
    }

    @Override
    public void testGetLength() {
        Assert.assertEquals(1 + 2 + "telecom/pb.vcf".length() * 2 + 2, h.getLength());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateNull(){
        new NameHeader(null);
    }

    @Test
    public void testParse() throws UnsupportedEncodingException {
        byte[] data = TestUtil.hexStringToByteArray("01002100740065006c00650063006f006d002f00700062002e0076006300660000");
        NameHeader h = NameHeader.parse(data);

        Assert.assertEquals("telecom/pb.vcf", h.getValue());
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertEquals("Name: telecom/pb.vcf", h.toString());
    }
}
