package com.company;

public class Bananas {

    public static int findK(int[] piles, int hour) {
        for (int i = 1; i < findMax(piles); i++) {
            int hoursSum = 0;
            for (int pile : piles) {
                hoursSum += pile / i + (pile % i > 0 ? 1 : 0);
            }
            if (hoursSum <= hour) {
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
