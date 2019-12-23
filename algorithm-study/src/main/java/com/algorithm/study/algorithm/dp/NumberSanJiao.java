package com.algorithm.study.algorithm.dp;

/**
 * 真正的自底向上
 * <p>
 * 从顶点开始,每个数字向下层走只能有左下和右下两个方向,求出到达最后一行时最大的路径之和。
 * <p>
 * 数字三角形最大的路径之和
 */
public class NumberSanJiao {
    /**
     * 递归最大的路径之和
     *
     * @param a
     * @param n 行数
     * @param i 行坐标
     * @param j 纵坐标
     * @return
     */
    public static int maxSumRe(int[][] a, int n, int i, int j) {
        if (i >= n) {
            return 0;
        }

        return Math.max(maxSumRe(a, n, i + 1, j), maxSumRe(a, n, i + 1, j + 1)) + a[i][j];
    }

    /**
     * dp最大的路径之和
     *
     * @param a
     * @param n
     * @return
     */
    public static int maxSumDp(int[][] a, int n) {
        int[][] dpMax = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dpMax[n][i] = a[n - 1][i - 1];
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                dpMax[i][j] = Math.max(dpMax[i + 1][j], dpMax[i + 1][j + 1]) + a[i - 1][j - 1];
            }
        }

        return dpMax[1][1];
    }
}
