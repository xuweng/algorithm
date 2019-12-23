package com.algorithm.study.algorithm.dp;

/**
 * 是否存在和等于sum的数字
 * <p>
 * 01背包类似
 * <p>
 * 这类题一般两个状态:i和sum
 * 这类题一般两个状态:i和v
 */
public class SelectSum {
    /**
     * 递归是否存在和等于sum的数字
     * <p>
     * 一般来说递归都要对参数判断,这里都要对i和s判断
     *
     * @param a
     * @param i a的下标
     * @param s 给出的和
     * @return
     */
    public static boolean selectSumRe(int[] a, int i, int s) {
        if (i < 0) {
            return false;
        }
        if (i == 0) {
            return s == a[i];
        }
        if (s <= 0) {
            return true;
        }
        if (a[i] > s) {
            return selectSumRe(a, i - 1, s);
        }
        return selectSumRe(a, i - 1, s) || selectSumRe(a, i - 1, s - a[i]);
    }

    /**
     * dp是否存在和等于sum的数字
     * <p>
     * f[i,s]:前i个数的和是否等于s
     *
     * @param a 数组
     * @param s 和,s>=0
     * @return
     */
    public static boolean selectSumDp(int[] a, int s) {
        int i = a.length;
        boolean[][] dpHas = new boolean[i + 1][s + 1];

        for (int k = 0; k <= s; k++) {
            dpHas[0][k] = false;
        }
        for (int k = 0; k <= i; k++) {
            dpHas[k][0] = true;
        }
        if (i >= 1) {
            for (int k = 0; k <= s; k++) {
                dpHas[1][k] = (a[0] == k);
            }
        }

        for (int k = 2; k <= i; k++) {
            for (int l = 1; l <= s; l++) {
                if (a[k - 1] > l) {
                    dpHas[k][l] = dpHas[k - 1][l];
                } else {
                    dpHas[k][l] = dpHas[k - 1][l] || dpHas[k - 1][l - a[k - 1]];
                }
            }
        }

        return dpHas[i][s];
    }
}
