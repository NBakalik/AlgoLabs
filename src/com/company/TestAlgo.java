package com.company;

import org.junit.Assert;
import org.junit.Test;

public class TestAlgo {
    @Test
    public void shouldFindK() {
        Assert.assertEquals(4, Bananas.findK(new int[]{3, 6, 7, 11}, 8));
        Assert.assertEquals(1, Bananas.findK(new int[]{30, 11, 23, 4, 20}, 100));
        Assert.assertEquals(23, Bananas.findK(new int[]{30, 11, 23, 4, 20}, 6));
    }
}
