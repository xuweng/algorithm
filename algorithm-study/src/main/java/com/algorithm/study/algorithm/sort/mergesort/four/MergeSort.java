package com.algorithm.study.algorithm.sort.mergesort.four;


public class MergeSort {
    public static void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    public static void sort(int[] data, int left, int right) {
        //递归条件
        if (left < right) {
            int center = (left + right) / 2;
            sort(data, left, center);
            sort(data, center + 1, right);
            merge(data, left, center, right);
        }
    }

    public static void merge(int[] data, int left, int center, int right) {
        // length of L
        int n1 = center - left + 1;
        // length of R
        int n2 = right - center;
        //留一个位置插入哨兵
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = data[left + i];
        }
        //最后一个位置插入哨兵。哨兵无穷大。假哨兵
        L[n1] = 999;  //guard

        for (int j = 0; j < n2; j++) {
            R[j] = data[center + j + 1];
        }
        //最后一个位置插入哨兵。哨兵无穷大。假哨兵
        R[n2] = 999; //guard

        int i = 0;//左指针
        int j = 0;//右指针
        //左部分走完,i指向哨兵
        //右部分走完,j指向哨兵
        // 把较小的数先移到新数组中
        for (int k = left; k <= right; k++) {
            if (L[i] <= R[j]) {
                data[k] = L[i++];
            } else {
                data[k] = R[j++];
            }
        }
    }
}
