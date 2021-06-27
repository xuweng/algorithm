package com.leetcode.tag.contest.must.one;

import java.util.Arrays;

/**
 * 5797. 两个数对之间的最大乘积差
 */
public class MaxProductDifference {
    class Solution {
        public int maxProductDifference(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);

            return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
        }
    }
}
