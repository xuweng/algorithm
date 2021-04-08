package com.leetcode.tag.must.one.nine;

/**
 * 718. 最长重复子数组
 */
public class FindLength {
    class Solution {
        public int findLength(int[] A, int[] B) {
            if (A == null || B == null) {
                return 0;
            }
            int[][] dp = new int[A.length + 1][B.length + 1];
            int max = 0;
            for (int i = 1; i <= A.length; i++) {
                for (int j = 1; j <= B.length; j++) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }

            return max;
        }
    }
}
