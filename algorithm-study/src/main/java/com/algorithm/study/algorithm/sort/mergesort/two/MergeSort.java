package com.algorithm.study.algorithm.sort.mergesort.two;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 1----->2--->4---->8-------->
 * <p>
 * 1.将原数组首先进行两个元素为一组的排序，然后合并为四个一组，八个一组，直至合并整个数组；
 * 2.合并两个子数组的时候，需要借助一个临时数组，用来存放当前的归并后的两个数组；
 * 3.将临时数组复制回原数组对应的位置。
 * <p>
 * 归并排序的非递归算法
 */
public class MergeSort {
    public static void main(String args[]) {
        MergeSort mer = new MergeSort();
        int[] array = mer.getArray();
        System.out.println("OriginalArray:" + Arrays.toString(array));
        mer.mergeSort(array);
        System.out.println("SortedArray:" + Arrays.toString(array));
    }

    public int[] getArray() {
        Scanner cin = new Scanner(System.in);
        System.out.print("Input the length of Array:");
        int length = cin.nextInt();
        int[] arr = new int[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = r.nextInt(100);
        }
        cin.close();
        return arr;
    }

    public void mergeSort(int[] a) {
        int len = 1;
        while (len < a.length) {
            for (int i = 0; i < a.length; i += 2 * len) {
                merge(a, i, len);
            }
            len *= 2;
        }
    }

    public void merge(int[] a, int i, int len) {
        int start = i;
        int len_i = i + len;//归并的前半部分数组
        int j = i + len;
        int len_j = j + len;//归并的后半部分数组
        int[] temp = new int[2 * len];
        int count = 0;
        while (i < len_i && j < len_j && j < a.length) {
            if (a[i] <= a[j]) {
                temp[count++] = a[i++];
            } else {
                temp[count++] = a[j++];
            }
        }
        while (i < len_i && i < a.length) {//注意：这里i也有可能超过数组长度
            temp[count++] = a[i++];
        }
        while (j < len_j && j < a.length) {
            temp[count++] = a[j++];
        }
        count = 0;
        while (start < j && start < a.length) {
            a[start++] = temp[count++];
        }
    }
}

