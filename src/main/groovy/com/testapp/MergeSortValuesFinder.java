package com.testapp;

import java.util.Arrays;

public class MergeSortValuesFinder extends GroovyValuesFinder {

    public static void sortArray(int[] array) {
        mergeSort(array);
    }

    public static int[] mergeSort(int[] list) {
        if (list.length < 2) {
            return list;
        }

        int halfIndex = list.length / 2;
        int[] first = Arrays.copyOfRange(list, 0, halfIndex);
        int[] second = Arrays.copyOfRange(list, halfIndex, list.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, list);
        return list;
    }

    private static void merge(int[] first, int[] second, int[] result) {
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;

        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[iMerged] = first[iFirst];
                iFirst = iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond = iSecond++;
            }
            iMerged = iMerged++;
        }
        System.arraycopy(first, iFirst, result, iMerged, (int) first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, (int) second.length - iSecond);
    }

}
