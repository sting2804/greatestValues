package com.testapp

import java.lang.reflect.Array

class Application {
    public static void main(String[] args) {
        def arrayList = []
        def random = new Random()
        for (int i = 0; i < 10000; i++) {
            arrayList << random.nextInt()
        }
        println arrayList
        int[] array = arrayList as int[]
        long startTime = System.currentTimeMillis()
        def result = null
        result = GroovyValuesFinder.getGreatestValuesWithoutDuplicates(array, 30)
        long stopTime = System.currentTimeMillis()
        println "G size: ${result.length}"
        println "G time: ${(stopTime - startTime) / 1000}"
        println()
        array = arrayList as int[]
        startTime = System.currentTimeMillis()
        result = ManualValuesFinder.getGreatestValuesWithoutDuplicates(array, 30)
        stopTime = System.currentTimeMillis()
        println "M size: ${result.length}"
        println "M time: ${(stopTime - startTime) / 1000}"
        println()

    }
}
