package com.leetcode.tag.must7.two;

/**
 * 5808. 数组串联
 */
public class GetConcatenation {
    class Solution {
        public int[] getConcatenation(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new int[0];
            }
            int[] result = new int[nums.length * 2];
            for (int i = 0; i < 2 * nums.length; i++) {
                result[i] = nums[i % nums.length];
            }

            return result;
        }
    }
}
