package com.algorithm.study;

import com.algorithm.study.common.ArrayUtils;
import com.algorithm.study.search.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTests {
    @Test
    public void searchRecursiveTest() {
        //测试找到
        Integer[] array = ArrayUtils.generateSortArray(1, 10);

        for (Integer i : array) {
            int index = BinarySearch.searchRecursive(array, 0, array.length - 1, i);

            Assert.assertEquals(array[index], i);
        }
        //测试找不到
        Integer[] notFindArray = ArrayUtils.generateSortArray(12, 15);
        for (Integer i : notFindArray) {
            int index = BinarySearch.searchRecursive(array, 0, array.length - 1, i);

            Assert.assertEquals(-1, index);
        }
    }

    @Test
    public void searchForTest() {
        //测试找到
        Integer[] array = ArrayUtils.generateSortArray(1, 10);

        for (Integer i : array) {
            int index = BinarySearch.searchFor(array, i);

            Assert.assertEquals(array[index], i);
        }
        //测试找不到
        Integer[] notFindArray = ArrayUtils.generateSortArray(12, 15);
        for (Integer i : notFindArray) {
            int index = BinarySearch.searchFor(array, i);

            Assert.assertEquals(-1, index);
        }
    }
}
