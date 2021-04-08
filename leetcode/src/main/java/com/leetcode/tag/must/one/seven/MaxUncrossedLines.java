package com.leetcode.tag.must.one.seven;

/**
 * 1035. 不相交的线
 */
public class MaxUncrossedLines {
    class Solution {
        public int maxUncrossedLines(int[] A, int[] B) {
            int[][] dp = new int[A.length + 1][B.length + 1];
            for (int i = 1; i <= A.length; i++) {
                for (int j = 1; j <= B.length; j++) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }

            return dp[A.length][B.length];
        }
    }
}
