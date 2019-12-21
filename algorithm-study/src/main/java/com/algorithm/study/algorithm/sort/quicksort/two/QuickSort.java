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
     * 一开始将小于v和大于v的元素放在数组的两端,等于v稍后再处理
     * arr[l+1...l-1]<v
     * arr[j...r]>v
     *
     * @param arr 数据
     * @param l   左边界
     * @param r   右边界
     * @return
     */
    public static int partition(int arr[], int l, int r) {
        int v = arr[l];
        int i, j;
        i = l + 1;
        j = r;
        while (true) {
            //合并
            //当i的元素小于v的时候继续向后扫描，直到碰到了arr[i]>=v
            while (arr[i] < v && i <= r) {
                i++;
            }
            //直到碰到某个元素arr[i]<=v
            while (j >= l + 1 && arr[j] > v) {
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
        ArrayUtils.swap(arr, l, j);

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
