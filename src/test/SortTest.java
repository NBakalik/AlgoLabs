package test;

import com.company.QuickSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {
    @Before
    public void init() {
        QuickSort.swaps = 0;
        QuickSort.comparisons = 0;
    }

    @Test
    public void shouldSortArrayInAscOrder() {
        int[] array = {1, 5, 9, -3, 12, 5};
        QuickSort.quickSort(array, 0, array.length - 1, "asc");
        Assert.assertEquals("[-3, 1, 5, 5, 9, 12]", Arrays.toString(array));
    }

    @Test
    public void shouldSortArrayInDescOrder() {
        int[] array = {1, 5, 9, -3, 12, 5};
        QuickSort.quickSort(array, 0, array.length - 1, "desc");
        Assert.assertEquals("[12, 9, 5, 5, 1, -3]", Arrays.toString(array));
    }

    @Test
    public void shouldSortInAscOrderSortedArrayInAscOrder() {
        int[] sortedArray = {1, 2, 3, 4, 5, 6};
        QuickSort.quickSort(sortedArray, 0, sortedArray.length - 1, "asc");
        Assert.assertEquals(20, QuickSort.swaps);
        Assert.assertEquals(15, QuickSort.comparisons);
    }

    @Test
    public void shouldSortInAscOrderSortedArrayInDescOrder() {
        int[] sortedArray = {6, 5, 4, 3, 2, 1};
        QuickSort.quickSort(sortedArray, 0, sortedArray.length - 1, "asc");
        Assert.assertEquals(11, QuickSort.swaps);
        Assert.assertEquals(15, QuickSort.comparisons);
    }

    @Test
    public void shouldSortInDescOrderSortedArrayInAscOrder() {
        int[] sortedArray = {1, 2, 3, 4, 5, 6};
        QuickSort.quickSort(sortedArray, 0, sortedArray.length - 1, "desc");
        Assert.assertEquals(11, QuickSort.swaps);
        Assert.assertEquals(15, QuickSort.comparisons);
    }

    @Test
    public void shouldSortInDescOrderSortedArrayInDescOrder() {
        int[] sortedArray = {6, 5, 4, 3, 2, 1};
        QuickSort.quickSort(sortedArray, 0, sortedArray.length - 1, "desc");
        Assert.assertEquals(20, QuickSort.swaps);
        Assert.assertEquals(15, QuickSort.comparisons);
    }

}
