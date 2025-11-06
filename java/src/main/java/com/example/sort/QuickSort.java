package com.example.sort;

public class QuickSort {
    public static void sort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivotIndex = locatePivot(arr, start, end);
        sort(arr, start, pivotIndex - 1);
        sort(arr, pivotIndex + 1, end);
    }

    public static int locatePivot(int[] arr, int start, int end) {
        int leftPointer = start + 1;
        int rightPointer = end;
        while (leftPointer <= rightPointer) {
            while (leftPointer <= end && arr[leftPointer] < arr[start])
                leftPointer++;
            while (rightPointer > start && arr[rightPointer] > arr[start])
                rightPointer--;

            if (leftPointer < rightPointer)
                swap(arr, leftPointer, rightPointer);
        }
        swap(arr, start, rightPointer);
        return rightPointer;
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}