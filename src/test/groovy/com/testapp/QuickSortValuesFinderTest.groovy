package com.testapp

import spock.lang.Specification

/**
 * Created by sting on 10/24/16.
 */
class QuickSortValuesFinderTest extends Specification {
    def "getLargestValues, no duplicates, sorted array"() {
        when:
        def res = QuickSortValuesFinder.getLargestValues(array, k)

        then:
        res == expectedResult

        where:
        array << [
                [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[],
                [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[],
                [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[],
                [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] as int[],
        ]
        k << [
                1, 2, 3, 4,
        ]
        expectedResult << [
                [11] as int[],
                [10, 11] as int[],
                [9, 10, 11] as int[],
                [8, 9, 10, 11] as int[],
        ]
    }

    def "getLargestValues, with duplicates, sorted array"() {
        when:
        def res = QuickSortValuesFinder.getLargestValues(array, k)

        then:
        res == expectedResult

        where:
        array << [
                [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10] as int[],
                [1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10, 10] as int[],
        ]
        k << [
                1, 2,
        ]
        expectedResult << [
                [10] as int[],
                [9, 10] as int[],
        ]
    }

    def "getLargestValues, no duplicates, not sorted array"() {
        when:
        def res = QuickSortValuesFinder.getLargestValues(array, k)

        then:
        res == expectedResult

        where:
        array << [
                [1, 4, 3, 2, 5, 8, 7, 9, 6, 10, 11] as int[],
                [11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1] as int[],
                [1, 2, 3, 4, 5, 6, 11, 8, 9, 10, 7] as int[],
                [10, 11, 3, 4, 5, 6, 7, 8, 9, 1, 2] as int[],
        ]
        k << [
                1, 2, 3, 4,
        ]
        expectedResult << [
                [11] as int[],
                [10, 11] as int[],
                [9, 10, 11] as int[],
                [8, 9, 10, 11] as int[],
        ]
    }

    def "getLargestValues, with duplicates, not sorted array"() {
        when:
        def res = QuickSortValuesFinder.getLargestValues(array, k)

        then:
        res == expectedResult

        where:
        array << [
                [10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1] as int[],
                [10, 9, 3, 4, 5, 6, 7, 8, 9, 10, 2] as int[],
        ]
        k << [
                1, 2,
        ]
        expectedResult << [
                [10] as int[],
                [9, 10] as int[],
        ]
    }
}
