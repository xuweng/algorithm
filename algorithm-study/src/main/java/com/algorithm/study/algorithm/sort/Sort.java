package com.algorithm.study.algorithm.sort;

import com.algorithm.study.common.ArrayUtils;

import java.util.Arrays;
import java.util.stream.Stream;

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

    /**
     * 排序的过程就是一种增加有序度，减少逆序度的过程，最后达到满有序度
     * <p>
     * 每交换一次，有序度就加 1。不管算法怎么改进，交换次数总是确定的，即为逆序度
     *
     * <p>
     * 冒泡排序，a表示数组，n表示数组大小
     * <p>
     * 交换、移动
     * <p>
     * 有数据区域、无数据区域
     * <p>
     * 排序区域、没排序区域
     *
     * @param a
     * @param n
     */
    public void bubbleSort(int[] a, int n) {
        //一个元素
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean isSwap = false;
            for (int j = 0; j < n - i - 1; ++j) {
                //稳定排序
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    isSwap = true;  // 表示有数据交换
                }
            }
            if (!isSwap) {
                break;  // 没有数据交换，提前退出
            }
        }
    }


    /**
     * 插入排序，a表示数组，n表示数组大小
     *
     * @param a
     * @param n
     */
    public void insertionSort(int[] a, int n) {
        //一个元素
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }


    /**
     * 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
     *
     * @param a
     * @param n
     */
    public void countingSort(Integer[] a, int n) {
        if (n <= 1) {
            return;
        }

        //int a = Stream.of(2,1,4,5,3).max(Integer::compare).get();------5
        //int b = Stream.of(2,1,4,5,3).min(Integer::compare).get();------1
        //int a = Stream.of(1,2,4,5,3).mapToInt(i -> i).max().getAsInt();
        // 查找数组中数据的范围
        int max = Stream.of(a).max(Integer::compare).get();
        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];
        Arrays.fill(c, 0);

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];
        // 计算排序的关键步骤，有点难理解
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝给a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }
}
