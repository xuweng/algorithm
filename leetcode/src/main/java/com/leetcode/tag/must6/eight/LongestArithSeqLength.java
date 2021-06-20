package com.leetcode.tag.must6.eight;

import java.util.Arrays;

/**
 * 1027. 最长等差数列
 */
public class LongestArithSeqLength {
    class Solution {
        public int longestArithSeqLength(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int offset = 10000;
            int[][] dp = new int[nums.length][2 * offset];
            for (int[] ints : dp) {
                Arrays.fill(ints, 1);
            }
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    int cha = nums[i] - nums[j];
                    dp[i][cha + offset] = Math.max(dp[i][cha + offset], dp[j][cha + offset] + 1);

                    max = Math.max(max, dp[i][cha + offset]);
                }
            }

            return max;
        }
    }
}
