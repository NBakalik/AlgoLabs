package test;

import com.company.PriorityQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class test {

    private PriorityQueue priorityQueue;

    @Before
    public void init() {
        priorityQueue = new PriorityQueue();
        priorityQueue.add(10, 4);
        priorityQueue.add(20, 1);
        priorityQueue.add(40, 3);
        priorityQueue.add(80, 2);
        priorityQueue.add(90, 7);
        priorityQueue.add(50, 5);
    }

    @Test
    public void shouldAddInPriority() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = System.out;
        try {
            System.setOut(new PrintStream(byteArrayOutputStream));
            priorityQueue.printQueue();
            String output = "20 1" + System.lineSeparator() +
                    "80 2" + System.lineSeparator() +
                    "40 3" + System.lineSeparator() +
                    "10 4" + System.lineSeparator() +
                    "50 5" + System.lineSeparator() +
                    "90 7" + System.lineSeparator();
            Assert.assertEquals(output, byteArrayOutputStream.toString());
        } finally {
            System.setOut(out);
        }
    }

    @Test
    public void shouldFindAndReturnIndex() {
        Assert.assertEquals(5, priorityQueue.indexOf(50));
    }

    @Test
    public void shouldPop() {
        priorityQueue.pop();
        Assert.assertEquals(5, priorityQueue.getSize());
    }
}
