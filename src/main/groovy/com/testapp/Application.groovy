package com.testapp

class Application {
    public static void main(String[] args) {
        def arrayList = []
        def random = new Random()
        for (int i = 0; i < 500000; i++) {
            arrayList << random.nextInt()
        }
        int[] array = arrayList as int[]
        long startTime = System.currentTimeMillis()
        def resultG = null
        def resultM = null
        def resultQ = null
        resultG = GroovyValuesFinder.getLargestValues(array, 30)
        long stopTime = System.currentTimeMillis()
        println "G size: ${resultG.length}"
        println "G time: ${(stopTime - startTime) / 1000}"
        println()

        array = arrayList as int[]
        startTime = System.currentTimeMillis()
        resultM = MergeSortValuesFinder.getLargestValues(array, 30)
        stopTime = System.currentTimeMillis()
        println "M size: ${resultM.length}"
        println "M time: ${(stopTime - startTime) / 1000}"
        println()

        array = arrayList as int[]
        startTime = System.currentTimeMillis()
        resultQ = QuickSortValuesFinder.getLargestValues(array, 30)
        stopTime = System.currentTimeMillis()
        println "Q size: ${resultQ.length}"
        println "Q time: ${(stopTime - startTime) / 1000}"
        println()

        assert resultG==resultM
        assert resultG==resultQ
    }
}
