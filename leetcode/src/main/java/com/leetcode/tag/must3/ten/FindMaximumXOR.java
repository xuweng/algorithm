package com.leetcode.tag.must3.ten;

/**
 * 421. 数组中两个数的最大异或值
 */
public class FindMaximumXOR {
    class Solution {
        public int findMaximumXOR(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    max = Math.max(max, nums[i] ^ nums[j]);
                }
            }

            return max;
        }
    }
}
