package com.testapp

class GroovyValuesFinder {

    static int[] getLargestValues(int[] array, int k) {
        if (k < 1 || k >= array.length)
            return array
        def resultList = []
        sortArray(array)
        array = removeDuplicates(array)
        resultList = array[array.length - k..array.length - 1]
        return resultList as int[]
    }

    static void sortArray(int[] array) {
        Arrays.parallelSort(array)
    }

    static int[] removeDuplicates(int[] array) {
        if (array.length < 2)
            return array
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] == array[i]) {
                def leftArray = array[0..i - 1]
                def rightArray = array.length - 1 > i ? array[i + 1..array.length - 1] : []
                array = leftArray + rightArray as int[]
            }
        }
        return array
    }
}
