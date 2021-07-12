package com.leetcode.tag.must7.three;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct {
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] zhe = new int[nums.length];
            int[] fu = new int[nums.length];
            if (nums[0] > 0) {
                zhe[0] = nums[0];
            }
            if (nums[0] < 0) {
                fu[0] = nums[0];
            }
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > 0) {
                    zhe[i] = Math.max(zhe[i - 1] * nums[i], nums[i]);
                    fu[i] = fu[i - 1] * nums[i];
                } else if (nums[i] < 0) {
                    zhe[i] = fu[i - 1] * nums[i];
                    fu[i] = Math.min(zhe[i - 1] * nums[i], nums[i]);
                }
                max = Math.max(max, zhe[i]);
            }

            return max;
        }
    }
}
