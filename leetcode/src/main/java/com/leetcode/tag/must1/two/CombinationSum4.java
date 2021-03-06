package com.leetcode.tag.must1.two;

/**
 * 377. 组合总和 Ⅳ
 */
public class CombinationSum4 {
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            if (nums == null) {
                return 0;
            }
            int[] dp = new int[target + 1];
            // 初始化
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (i < num) {
                        continue;
                    }
                    dp[i] += dp[i - num];
                }
            }

            return dp[target];
        }
    }
}
