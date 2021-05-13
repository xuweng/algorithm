package com.leetcode.tag.must3.six;

/**
 * 238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            // 上三角
            for (int i = 1; i < nums.length; i++) {
                dp[i] = dp[i - 1] * nums[i - 1];
            }
            int temp = 1;
            // 下三角
            for (int i = nums.length - 2; i >= 0; i--) {
                temp *= nums[i + 1];
                dp[i] *= temp;
            }

            return dp;
        }
    }
}
