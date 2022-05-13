package com.company;

import org.junit.Assert;
import org.junit.Test;

public class FantzTest {
    @Test
    public void shouldFindMinNumber() {
        Fantz fantz = new Fantz("input.txt");
        fantz.findSubNumbers(fantz.x);
        Assert.assertEquals(3, fantz.count);
    }

    @Test
    public void shouldFindMinNumber2() {
        Fantz fantz = new Fantz("input2.txt");
        fantz.findSubNumbers(fantz.x);
        Assert.assertEquals(1, fantz.count);
    }

    @Test
    public void shouldFindMinNumber3() {
        Fantz fantz = new Fantz("input3.txt");
        fantz.findSubNumbers(fantz.x);
        Assert.assertEquals(3, fantz.count);
    }

}
