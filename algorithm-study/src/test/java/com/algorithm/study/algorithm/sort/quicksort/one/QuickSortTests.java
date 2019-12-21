package com.algorithm.study.algorithm.sort.quicksort.one;

import org.junit.Test;

import java.util.Arrays;

/**
 * 重复数据，正序数据一样的性质
 */
public class QuickSortTests {
    /**
     * 重复数据测试
     */
    @Test
    public void partitionTest() {
        int[] array = new int[100];
        Arrays.fill(array, 2);

        for (int i = 0; i < array.length; i++) {
            System.out.println(QuickSort.partition(array, i, array.length - 1));
        }
    }

    /**
     * 正序数据测试
     */
    @Test
    public void partitionTest1() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(QuickSort.partition(array, i, array.length - 1));
        }
    }

    /**
     * 随机数据测试
     */
    @Test
    public void partitionTest2() {
        int[] array = {4, 3, 7, 8, 2, 1, 6, 5};

        for (int i = 0; i < array.length; i++) {
            System.out.println(QuickSort.partition(array, i, array.length - 1));
        }
    }
}
