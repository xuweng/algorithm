package com.algorithm.study.search;

import java.util.Objects;

public class BinarySearch {
    /**
     * 递归二分查找
     *
     * @param array 有序数组
     * @param low   开始索引
     * @param high  结束索引
     * @param value 查找的值
     * @return 找到返回索引;否则返回-1
     */
    public static int searchRecursive(Integer array[], int low, int high, int value) {
        Objects.requireNonNull(array);
        if (low < 0 || high >= array.length) {
            throw new IllegalArgumentException();
        }
        if (array.length == 0) {
            return -1;
        }
        if (low > high) {
            return -1;
        }

        int middle = (low + high) / 2;

        if (array[middle] == value) {
            return middle;
        } else if (array[middle] < value) {
            return searchRecursive(array, middle + 1, high, value);
        } else if (array[middle] > value) {
            return searchRecursive(array, low, middle - 1, value);
        }

        return -1;
    }

    /**
     * @param array 有序数组
     * @param value 查找的值
     * @return 找到返回索引;否则返回-1
     */
    public static int searchFor(Integer array[], int value) {
        Objects.requireNonNull(array);
        if (array.length == 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (array[middle] == value) {
                return middle;
            } else if (array[middle] < value) {
                low = middle + 1;
            } else if (array[middle] > value) {
                high = middle - 1;
            }
        }

        return -1;
    }
}