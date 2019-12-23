package com.algorithm.study.algorithm.dp;

import java.util.Objects;

/**
 * 编辑距离
 */
public class MinDistanse {
    /**
     * 递归编辑距离
     * <p>
     * 返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
     * <p>
     * s1变成s2,对s1操作
     *
     * @param s1
     * @param s2
     * @param i
     * @param j
     * @return
     */
    public static int findMinDistanseRe(String s1, String s2, int i, int j) {
        Objects.requireNonNull(s1);
        Objects.requireNonNull(s2);

        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        //不操作
        if (s1.charAt(i) == s2.charAt(j)) {
            return findMinDistanseRe(s1, s2, i - 1, j - 1);
        } else {
            int x = findMinDistanseRe(s1, s2, i, j - 1) + 1;//插入
            int y = findMinDistanseRe(s1, s2, i - 1, j) + 1;//删除
            int z = findMinDistanseRe(s1, s2, i - 1, j - 1) + 1;//替换

            return Math.min(Math.min(x, y), z);
        }
    }

    /**
     * dp编辑距离
     * dp[i][j]的含义是：对于s1[1..i]和s2[1..j]，它们的编辑距离是dp[i][j]
     *
     * @return
     */
    public static int findMinDistanseDp(String s1, String s2) {
        Objects.requireNonNull(s1);
        Objects.requireNonNull(s2);

        int i = s1.length();//行
        int j = s2.length();//列
        int[][] dpMin = new int[i + 1][j + 1];
        for (int k = 0; k <= j; k++) {
            dpMin[0][k] = k;
        }
        for (int k = 0; k <= i; k++) {
            dpMin[k][0] = k;
        }

        for (int k = 1; k <= i; k++) {
            for (int l = 1; l <= j; l++) {
                if (s1.charAt(k - 1) == s2.charAt(l - 1)) {
                    dpMin[k][l] = dpMin[k - 1][l - 1];
                } else {
                    int x = dpMin[k][l - 1] + 1;
                    int y = dpMin[k - 1][l] + 1;
                    int z = dpMin[k - 1][l - 1] + 1;

                    dpMin[k][l] = Math.min(Math.min(x, y), z);
                }
            }
        }

        return dpMin[i][j];
    }
}
