package com.leetcode.tag.dp;

/**
 * 53. 最大子序和
 */
public class MaxSubArray {
    /**
     * 用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」
     * <p>
     * 动态规划转移方程：
     * <p>
     * f(i) = max{f(i - 1)+ a_i,a_i}
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
    }

    class Solution1 {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
