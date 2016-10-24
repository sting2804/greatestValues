package com.testapp;

public class QuickSortValuesFinder extends GroovyValuesFinder {

    private static int number;
    private static int[] numbers;


    public static void sortArray(int[] array) {
        if (array == null || array.length == 0) return;
        numbers = array;
        number = array.length;
        quicksort(0, (int) number - 1);
    }

    private static void quicksort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = numbers[low + (high - low) / 2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i = i++;
            }

            while (numbers[j] > pivot) {
                j = j--;
            }


            if (i <= j) {
                exchange(i, j);
                i = i++;
                j = j--;
            }

        }

        if (low < j) quicksort(low, j);
        if (i < high) quicksort(i, high);
    }

    private static void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
