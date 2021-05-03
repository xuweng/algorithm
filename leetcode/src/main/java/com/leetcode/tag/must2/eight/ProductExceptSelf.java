package com.leetcode.tag.must2.eight;

/**
 * 238. 除自身以外数组的乘积
 * <p>
 * 正负 正负 正负
 * <p>
 * 负数取模 负数取模 负数取模
 * <p>
 * 溢出 溢出 溢出
 */
public class ProductExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            // 下三角
            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] * nums[i - 1];
            }
            int temp = 1;
            // 上三角
            for (int i = nums.length - 2; i >= 0; i--) {
                temp = temp * nums[i + 1];
                dp[i] *= temp;
            }

            return dp;
        }
    }
}
