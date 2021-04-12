package com.leetcode.tag.must.six;

/**
 * 1567. 乘积为正数的最长子数组长度
 */
public class GetMaxLen1 {
    class Solution {
        public int getMaxLen(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] zhe = new int[nums.length];
            int[] fu = new int[nums.length];
            if (nums[0] > 0) {
                zhe[0] = 1;
            }
            if (nums[0] < 0) {
                fu[0] = 1;
            }
            int max = zhe[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > 0) {
                    zhe[i] = zhe[i - 1] + 1;
                    fu[i] = fu[i - 1] > 0 ? fu[i - 1] + 1 : 0;
                } else if (nums[i] < 0) {
                    zhe[i] = fu[i - 1] > 0 ? fu[i - 1] + 1 : 0;
                    fu[i] = zhe[i - 1] + 1;
                }
                max = Math.max(max, zhe[i]);
            }

            return max;
        }
    }
}
