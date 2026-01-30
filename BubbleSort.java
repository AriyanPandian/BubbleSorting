package com.bubblesort;

import java.util.Arrays;

public class BubbleSort {
    
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break;
            }
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void optimizedSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        int lastSwapIndex = n - 1;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            int currentSwapIndex = 0;
            
            for (int j = 0; j < lastSwapIndex; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                    currentSwapIndex = j;
                }
            }
            
            if (!swapped) {
                break;
            }
            
            lastSwapIndex = currentSwapIndex;
        }
    }
    
    public void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    
    public long measureSortTime(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        long startTime = System.nanoTime();
        sort(copy);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
