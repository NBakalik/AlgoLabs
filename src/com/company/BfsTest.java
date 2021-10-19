package com.company;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BfsTest {
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
    public void shouldCountLargestWay1() {
        Graph graph = new Graph();
        graph.readFile("input.txt");
        System.out.println(graph.getLargestWay());
        Assert.assertEquals("11" + System.lineSeparator(), out.toString());
    }

    @Test
    public void shouldCountLargestWay2() {
        Graph graph = new Graph();
        graph.readFile("input2.txt");
        System.out.println(graph.getLargestWay());
        Assert.assertEquals("3" + System.lineSeparator(), out.toString());
    }

    @Test
    public void shouldCountLargestWay3() {
        Graph graph = new Graph();
        graph.readFile("input3.txt");
        System.out.println(graph.getLargestWay());
        Assert.assertEquals("2" + System.lineSeparator(), out.toString());
    }
}
