package com.algorithm.study.algorithm.dp;

import java.util.Objects;

/**
 * 最长公共子序列长度
 * 涉及子序列问题，十有八九都需要动态规划来解决
 */
public class LongestCommonSubsequence {
    /**
     * 递归最长公共子序列长度
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int findLCSRe(String s1, String s2, int i, int j) {
        Objects.requireNonNull(s1);
        Objects.requireNonNull(s2);
        if (i < 0 || j < 0) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return findLCSRe(s1, s2, i - 1, j - 1) + 1;
        } else {
            return Math.max(findLCSRe(s1, s2, i, j - 1), findLCSRe(s1, s2, i - 1, j));
        }
    }

    /**
     * dp最长公共子序列长度
     * 定义：索引是从 1 开始,dp[i][j]的含义是：对于s1[1..i]和s2[1..j]，它们的 LCS 长度是dp[i][j]
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int findLCSDp(String s1, String s2) {
        //s1横坐标
        //s2纵坐标
        int i = s1.length();
        int j = s2.length();
        int[][] dpMax = new int[i + 1][j + 1];
        for (int k = 0; k <= j; k++) {
            dpMax[0][k] = 0;
        }
        for (int k = 0; k <= i; k++) {
            dpMax[k][0] = 0;
        }

        for (int k = 1; k <= i; k++) {
            for (int l = 1; l <= j; l++) {
                if (s1.charAt(k - 1) == s2.charAt(l - 1)) {
                    dpMax[k][l] = dpMax[k - 1][l - 1] + 1;
                } else {
                    dpMax[k][l] = Math.max(dpMax[k][l - 1], dpMax[k - 1][l]);
                }
            }
        }

        return dpMax[i][j];
    }
}
