package com.algorithm.study.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最长上升子序列
 * d(i)就是找以A[i]结尾的lis
 */
public class LIS {
    //备忘录
    private static int[] memo = new int[100];

    static {
        Arrays.fill(memo, -1);
    }

    /**
     * 递归最长上升子序列
     *
     * @param a
     * @param i 数组下标
     * @return
     */
    public static int lisRe(int a[], int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return 1;
        }
        int max = -1;
        for (int j = 0; j <= i - 1; j++) {
            int temp = a[j] > a[i] ? 1 : lisRe(a, j) + 1;
            max = Math.max(max, temp);
        }

        return max;
    }

    /**
     * 递归备忘录最长上升子序列
     *
     * @param a
     * @param i 数组下标
     * @return
     */
    public static int lisReMemo(int a[], int i) {
        if (memo[i] != -1) {
            return memo[i];
        }
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            memo[i] = 1;
            return memo[i];
        }
        int max = -1;
        for (int j = 0; j <= i - 1; j++) {
            int temp = a[j] > a[i] ? 1 : lisRe(a, j) + 1;
            max = Math.max(max, temp);
        }
        memo[i] = max;
        return max;
    }

    /**
     * dp最长上升子序列
     *
     * @param a
     * @return
     */
    public static int lisDp(int a[]) {
        int n = a.length;
        int[] dpMax = new int[n + 1];
        dpMax[0] = 0;
        dpMax[1] = 1;

        for (int i = 2; i <= n; i++) {
            int max = -1;
            for (int j = 1; j <= i - 1; j++) {
                int temp = (a[j - 1] > a[i - 1]) ? 1 : dpMax[j] + 1;
                max = Math.max(max, temp);
            }
            dpMax[i] = max;
        }

        return dpMax[n];
    }

    /**
     * 二分查找最长上升子序列
     *
     * @param a
     * @return
     */
    public static int lisBinary(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        if (a.length == 1) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(a[0]);

        for (int i = 1; i < a.length; i++) {
            if (a[i] > list.get(list.size() - 1)) {
                list.add(a[i]);
            } else {
                list.set(binarySearch(list.toArray(new Integer[0]), a[i], 0, list.size() - 1), a[i]);
            }
        }

        return list.size();
    }

    /**
     * @param a
     * @param key 关键字
     * @param i   低下标
     * @param j   高下标
     * @return
     */
    private static int binarySearch(Integer[] a, int key, int i, int j) {
        if (i >= j) {
            return i;
        }
        int m = (i + j) / 2;
        if ((key <= a[m]) && ((m - 1 < 0) || (key > a[m - 1]))) {
            return m;
        } else if (key < a[m]) {
            return binarySearch(a, key, i, m - 1);
        } else {
            return binarySearch(a, key, m + 1, j);
        }
    }
}
