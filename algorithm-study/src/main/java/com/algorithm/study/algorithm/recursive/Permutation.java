package com.algorithm.study.algorithm.recursive;

import com.algorithm.study.common.ArrayUtils;

import java.util.Arrays;

/**
 * 全排列
 */
public class Permutation {
    public static int size = 0;

    public static void permutation(int[] array, int n) {
        //一个数不需要排列
        if (n <= 0) {
            //输出一次排列
            size++;
            System.out.println(Arrays.toString(array));
            return;
        }
        for (int i = 0; i <= n; i++) {
            //一次排列
            ArrayUtils.swap(array, i, n);
            permutation(array, n - 1);

            //恢复数据
            ArrayUtils.swap(array, i, n);
        }
    }

}
