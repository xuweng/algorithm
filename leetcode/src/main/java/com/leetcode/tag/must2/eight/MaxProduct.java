package com.leetcode.tag.must2.eight;

/**
 * 152. 乘积最大子数组
 * <p>
 * 负数取模 负数取模 负数取模
 * <p>
 * 溢出 溢出 溢出
 */
public class MaxProduct {
    class Solution {
        public int maxProduct(int[] nums) {
            int[] zhe = new int[nums.length];
            int[] fu = new int[nums.length];
            int max = 0;

            if (nums[0] > 0) {
                zhe[0] = nums[0];
            }
            if (nums[0] < 0) {
                fu[0] = nums[0];
            }

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > 0) {
                    zhe[i] = zhe[i - 1] != 0 ? zhe[i - 1] * nums[i] : nums[i];
                    fu[i] = fu[i - 1] != 0 ? fu[i - 1] * nums[i] : 0;
                } else if (nums[i] < 0) {
                    zhe[i] = fu[i - 1] != 0 ? fu[i - 1] * nums[i] : 0;
                    fu[i] = zhe[i - 1] != 0 ? zhe[i - 1] * nums[i] : nums[i];
                }

                max = Math.max(max, zhe[i]);
            }

            return max;
        }
    }
}
