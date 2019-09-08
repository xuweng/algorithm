package com.algorithm.study.sort;

import com.algorithm.study.common.ArrayUtils;

/**
 * 排序复杂度
 * 排序：O（n2）。O（nlogn）。
 */
public class Sort {
    /**
     * 选择排序
     * 复杂度：O(n2)
     *
     * @param array 待排序数组
     */
    public static void selectSort(Integer[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = ArrayUtils.findMinValueIndex(array, i, array.length);

            ArrayUtils.swapValue(array, i, minIndex);
        }
    }

    /**
     * 插入排序
     * 复杂度：O(n2)
     *
     * @param array
     */
    public static void insertSort(Integer[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return;
        }

        //元素个数>=1
        for (int i = 1; i < array.length; i++) {
            ArrayUtils.setFirstSmallValue(array, 0, i);
        }
    }

    /**
     * 快速排序
     * 最坏情况：O(n2)
     * 平均情况：O(nlogn)
     * <p>
     * 层数为O(log n)（用技术术语说，调用栈的高度为O(log n)），而每层需要的
     * 时间为O(n)。因此整个算法需要的时间为
     * O(n) * O(log n) = O(nlogn)。这就是最佳情况。
     * 在最糟情况下，有O(n)层，因此该算法的运行时间为
     * O(n) * O(n) = O(n2)。
     * <p>
     * 每层：O（n）
     * 高度：O（logn）或者O（n）
     * <p>
     * 实现快速排序时，请随机地选择用作基准值的元素
     *
     * @param array
     * @param startIndex 开始索引
     * @param endIndex   结束索引
     */
    public static void quickSort(Integer[] array, Integer startIndex, Integer endIndex) {
        if (ArrayUtils.isEmpty(array)) {
            return;
        }
        //一个元素就是有序
        if (startIndex >= endIndex) {
            return;
        }

        int partitionIndex = ArrayUtils.partition(array, startIndex, endIndex);
        quickSort(array, startIndex, partitionIndex - 1);
        quickSort(array, partitionIndex + 1, endIndex);
    }

}
