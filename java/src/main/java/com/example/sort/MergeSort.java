package com.example.sort;

public class MergeSort {
    public static void sort(int[] list, int start, int end) {
        if (start >= end) { return; }

        int mid = (start + end) / 2;
        sort(list, start, mid);
        sort(list, mid + 1, end);
        merge(list, start, end);
    }

    private static void merge(int[] list, int start, int end) {
        int[] temp = new int[end - start + 1];

        int mid = (start + end) / 2;
        int leftPointer = start;
        int rightPointer = mid + 1;

        for (int i = start; i <= end; i++) {
            if (leftPointer > mid)
                temp[i - start] = list[rightPointer++];
            else if (rightPointer > end)
                temp[i - start] = list[leftPointer++];
            else if (list[leftPointer] <= list[rightPointer])
                temp[i - start] = list[leftPointer++];
            else
                temp[i - start] = list[rightPointer++];
        }

        if (end + 1 - start >= 0)
            System.arraycopy(temp, 0, list, start, end + 1 - start);
    }
}
