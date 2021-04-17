package com.leetcode.tag.must1.one;

import java.util.Arrays;

/**
 * 1027. 最长等差数列
 */
public class LongestArithSeqLength {
    class Solution {
        public int longestArithSeqLength(int[] A) {
            if (A == null) {
                return 0;
            }
            int offset = 10000;
            // 结尾 公差
            int[][] dp = new int[A.length][2 * offset];
            for (int[] ints : dp) {
                Arrays.fill(ints, 1);
            }
            int max = 1;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < i; j++) {
                    int cha = A[i] - A[j];
                    dp[i][cha + offset] = Math.max(dp[i][cha + offset], dp[j][cha + offset] + 1);

                    max = Math.max(max, dp[i][cha + offset]);
                }
            }

            return max;
        }
    }
}
