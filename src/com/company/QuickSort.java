package com.company;

public class QuickSort {
    public static int comparisons;
    public static int swaps;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] array = parseInput(args);
        quickSort(array, 0, array.length - 1, args[0]);
        long endTime = System.currentTimeMillis();
        printInfo(array, endTime - startTime);
    }

    public static void printInfo(int[] array, long time) {
        System.out.println("QuickSort: ");
        System.out.println("execution time: " + time);
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        for (int val : array) {
            System.out.print(val + " ");
        }
    }

    public static int[] parseInput(String[] input) {
        String[] inputArray = input[1].split(",");
        int[] outputArray = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            outputArray[i] = Integer.parseInt(inputArray[i]);
        }
        return outputArray;
    }

    public static void quickSort(int arr[], int begin, int end, String order) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end, order);
            quickSort(arr, begin, partitionIndex - 1, order);
            quickSort(arr, partitionIndex + 1, end, order);
        }
    }

    private static int partition(int arr[], int begin, int end, String order) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (order.equals("asc")) {
                comparisons++;
                if (arr[j] <= pivot) {
                    comparisons++;
                    if (i + 1 != j) {
                        swap(arr, i + 1, j);
                    }
                    i++;
                }
            } else {
                comparisons++;
                if (arr[j] >= pivot) {
                    comparisons++;
                    if (i + 1 != j) {
                        swap(arr, i + 1, j);
                    }
                    i++;
                }
            }
        }
        if (i + 1 != end) {
            swap(arr, i + 1, end);
        }
        return i + 1;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        swaps++;
    }
    //java -classpath D:\Algo_labs\QuickSort\src com.company.QuickSort asc 1,2,3,4
}
