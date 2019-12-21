package com.algorithm.study.algorithm.sort.quicksort.one;

import org.junit.Test;

import java.util.Arrays;

/**
 * 重复数据，正序数据一样的性质
 */
public class QuickSortTests {
    private int[] array1 = new int[100];
    private int[] array2 = new int[100];
    private int[] array3 = {4, 3, 7, 8, 2, 1, 6, 5};

    /**
     * 重复数据测试
     */
    @Test
    public void partitionTest() {
        Arrays.fill(array1, 2);

        for (int i = 0; i < array1.length; i++) {
            System.out.println(QuickSort.partition(array1, i, array1.length - 1));
        }
    }

    /**
     * 正序数据测试
     */
    @Test
    public void partitionTest1() {
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i;
        }

        for (int i = 0; i < array2.length; i++) {
            System.out.println(QuickSort.partition(array2, i, array2.length - 1));
        }
    }

    /**
     * 随机数据测试
     */
    @Test
    public void partitionTest2() {
        for (int i = 0; i < array3.length; i++) {
            System.out.println(QuickSort.partition(array3, i, array3.length - 1));
        }
    }

    /**
     * 重复数据测试
     */
    @Test
    public void advancedPartitionTest() {
        Arrays.fill(array1, 2);

        for (int i = 0; i < array1.length; i++) {
            System.out.println(QuickSort.advancedPartition(array1, i, array1.length - 1));
        }
    }

    /**
     * 正序数据测试
     */
    @Test
    public void advancedPartitionTest1() {
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i;
        }

        for (int i = 0; i < array2.length; i++) {
            System.out.println(QuickSort.advancedPartition(array2, i, array2.length - 1));
        }
    }

    /**
     * 随机数据测试
     */
    @Test
    public void advancedPartitionTest2() {
        for (int i = 0; i < array3.length; i++) {
            System.out.println(QuickSort.advancedPartition(array3, i, array3.length - 1));
        }
    }
}
