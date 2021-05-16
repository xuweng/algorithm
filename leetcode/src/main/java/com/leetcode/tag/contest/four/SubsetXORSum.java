package com.leetcode.tag.contest.four;

/**
 * 5759. 找出所有子集的异或总和再求和
 */
public class SubsetXORSum {
    class Solution {
        public int subsetXORSum(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    sum += nums[i] ^ nums[j];
                }
            }

            return sum;
        }
    }
}
