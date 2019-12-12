package com.algorithm.study.algorithm;

import com.algorithm.study.common.ArrayUtils;
import com.algorithm.study.algorithm.search.BinarySearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BinarySearchTests {
    @Test
    public void searchRecursiveTest() {
        //测试找到
        Integer[] array = ArrayUtils.generateSortArray(1, 10);

        for (Integer i : array) {
            int index = BinarySearch.searchRecursive(array, 0, array.length - 1, i);

            assertEquals(array[index], i);
        }
        //测试找不到
        Integer[] notFindArray = ArrayUtils.generateSortArray(12, 15);
        for (Integer i : notFindArray) {
            int index = BinarySearch.searchRecursive(array, 0, array.length - 1, i);

            assertEquals(-1, index);
        }
    }

    @Test
    public void searchForTest() {
        //测试找到
        Integer[] array = ArrayUtils.generateSortArray(1, 10);

        for (Integer i : array) {
            int index = BinarySearch.searchFor(array, i);

            assertEquals(array[index], i);
        }
        //测试找不到
        Integer[] notFindArray = ArrayUtils.generateSortArray(12, 15);
        for (Integer i : notFindArray) {
            int index = BinarySearch.searchFor(array, i);

            assertEquals(-1, index);
        }
    }
}
