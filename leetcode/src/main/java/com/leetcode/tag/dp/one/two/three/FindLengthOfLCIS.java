package com.leetcode.tag.dp.one.two.three;

/**
 * 674. 最长连续递增序列
 * <p>
 * 子序列 背包
 * <p>
 * 子序列 背包 子序列 背包 子序列 背包 子序列 背包
 * <p>
 * 子序列 背包 子序列 背包 子序列 背包 子序列 背包
 * <p>
 * 类型 类型
 * <p>
 * 连续 不连续
 * <p>
 * 连续 不连续
 */
public class FindLengthOfLCIS {
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                if (nums[i] > nums[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
