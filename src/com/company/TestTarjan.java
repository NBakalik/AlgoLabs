package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class TestTarjan {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setStream() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void restoreInitialStream() {
        System.setOut(originalOut);
    }

   @Test
    public void shouldCountLargestWay2() {
       Tarjan t = new Tarjan("input.txt");
       List<List<Integer>> scComponents = t.getSCComponents();
       System.out.println(t.getSccCount());
       System.out.println(scComponents);
       String expectedOutput = "3" + System.lineSeparator() +
               "[[5, 6], [7, 3, 2], [4, 1, 0]]" + System.lineSeparator();
       Assert.assertEquals(expectedOutput, out.toString());
    }
}
