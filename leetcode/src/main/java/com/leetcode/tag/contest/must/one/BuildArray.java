package com.leetcode.tag.contest.must.one;

/**
 * 5800. 基于排列构建数组
 */
public class BuildArray {
    class Solution {
        public int[] buildArray(int[] nums) {
            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                result[i] = nums[nums[i]];
            }

            return result;
        }
    }
}
