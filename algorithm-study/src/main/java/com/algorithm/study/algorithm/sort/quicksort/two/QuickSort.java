package com.algorithm.study.algorithm.sort.quicksort.two;

import com.algorithm.study.common.ArrayUtils;

/**
 * 看图分析
 * <p>
 * 一开始将小于v和大于v的元素放在数组的两端,等于v稍后再处理
 * <p>
 * https://blog.csdn.net/k_koris/article/details/80585979
 */
public class QuickSort {
    /**
     * 画图分析
     * <p>
     * 一开始将小于v和大于v的元素放在数组的两端,等于v稍后再处理
     * arr[l+1...l-1]<v
     * arr[j...r]>v
     *
     * @param arr   数据
     * @param left  左边界。数组下标。
     * @param right 右边界。数组下标。
     * @return
     */
    public static int partition(int arr[], int left, int right) {
        //swap(arr[left],arr[rand()%(r-l+1)+l]);//随机取参考值的大小
        //arr[left]是一个随机选择数
        //v是一个随机选择数。应付高度有序。
        int v = arr[left];
        int i = left + 1, j = right;
        while (true) {
            //合并
            //当i的元素小于v的时候继续向后扫描，直到碰到了arr[i]>=v
            while (arr[i] < v && i <= right) {
                i++;
            }
            //直到碰到某个元素arr[i]<=v
            while (j >= left + 1 && arr[j] > v) {
                j--;
            }

            if (i > j) {
                break;
            }
            //i，j两两交换。两个数相等时也会交换
            ArrayUtils.swap(arr, i, j);
            i++;
            j--;
        }
        //设置基准元素
        ArrayUtils.swap(arr, left, j);

        return j;
    }

    /**
     * 一个数不用排序
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void __quicksort2(int arr[], int l, int r) {
        //终止条件
        if (l >= r) {
            return;
        }

        int p = partition(arr, l, r);
        __quicksort2(arr, l, p - 1);
        __quicksort2(arr, p + 1, r);

    }


    public static void quicksort(int arr[], int n) {
        __quicksort2(arr, 0, n - 1);
    }

}
