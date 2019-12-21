package com.algorithm.study.algorithm.search;

import java.util.Objects;

/**
 * 看似越简单的东西往往越难掌握好，想要灵活应用就更加困难。
 * <p>
 * 查找复杂度
 * 查找：O（n）。O（logn）。O（1）。
 */
public class BinarySearch {
    /**
     * 递归二分查找
     * <p>
     * 复杂度：O(logn)
     *
     * @param array 有序数组
     * @param low   开始索引
     * @param high  结束索引
     * @param value 查找的值
     * @return 找到返回索引;否则返回-1
     */
    public static int searchRecursive(Integer[] array, int low, int high, int value) {
        Objects.requireNonNull(array);
        if (low < 0 || high >= array.length) {
            throw new IllegalArgumentException();
        }
        if (array.length == 0 || low > high) {
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
     * 遍历二分查找
     * 复杂度：O(logn)
     *
     * @param array 有序数组
     * @param value 查找的值
     * @return 找到返回索引;否则返回-1
     */
    public static int searchFor(Integer[] array, int value) {
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

    /**
     * 代码模板
     * <p>
     * 最简单的情况就是有序数组中不存在重复元素
     * <p>
     * 一个数不需要排序。但是一个数还需要查找。
     *
     * @param a     数据
     * @param n     数量
     * @param value 值
     * @return
     */
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;//数组下标
        int high = n - 1;//数组下标

        while (low <= high) {
//            int mid = (low + high) / 2;
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


    /**
     * 二分查找的递归实现
     *
     * @param a
     * @param n
     * @param val
     * @return
     */
    public static int bsearchRecursive(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    /**
     * 代码模板
     * <p>
     * 就用这个代码模板
     *
     * @param a
     * @param low   数组下标
     * @param high  数组下标
     * @param value
     * @return
     */
    private static int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }
}