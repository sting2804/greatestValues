package com.testapp

/**
 * Created by sting on 10/20/16.
 */
class MergeSortValuesFinder extends GroovyValuesFinder {

    static void sortArray(int[] array) {
        mergeSort(array)
    }

    public static int[] mergeSort(int[] list) {
        if (list.length < 2) {
            return list;
        }

        //разделение массива попалам
        int halfIndex = list.length / 2
        int[] first = list[0..halfIndex - 1] as int[]
        int[] second = list[halfIndex..list.length - 1] as int[]
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        //рекурсивная сортировка каждой половину
        mergeSort(first);
        mergeSort(second);

        //соединение отсортированных половин
        merge(first, second, list);
        return list;
    }

    private static void merge(int[] first, int[] second, int[] result) {
        //начальный индекс для первого массива
        int iFirst = 0;

        //начальный индекс для второго массива
        int iSecond = 0;

        //начальный индекс для третьего массива
        int iMerged = 0;

        //сравнение элементов по индексам iFirst и iSecond,
        //и перемещение меньшего по индексу iMerged
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].compareTo(second[iSecond]) < 0) {
                result[iMerged] = first[iFirst];
                iFirst++;
            } else {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        //копирование элементов из обоих половин
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }
}
