package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(findK(new int[]{3, 6, 7, 11}, 8));
        System.out.println(findK(new int[]{30, 11, 23, 4, 20}, 100));
        System.out.println(findK(new int[]{30, 11, 23, 4, 20}, 6));
    }

    private static int findK(int[] piles, int hour) {
        if (piles.length == hour) {
            return findMax(piles);
        }
        int[] hours = new int[piles.length];
        for (int i = 1; i < findMax(piles); i++) {
            for (int j = 0; j < piles.length; j++) {
                if (i > piles[j])
                    hours[j] = 1;
                else
                    hours[j] = piles[j] / i + (piles[j] % i > 0 ? 1 : 0);
            }
            int sum = Arrays.stream(hours).sum();
            if (sum <= hour) {
                return i;
            }
        }
        return -1;
    }

    private static int findMax(int[] piles) {
        heapSort(piles);
        return piles[0];
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] < arr[largest])
            largest = l;
        if (r < n && arr[r] < arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
