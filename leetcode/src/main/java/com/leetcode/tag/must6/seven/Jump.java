package com.leetcode.tag.must6.seven;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 */
public class Jump {
    class Solution {
        public int jump(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }

            return dp[nums.length - 1];
        }
    }
}
