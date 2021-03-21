package com.leetcode.tag.contest.two;

/**
 * 5696. 统计异或值在范围内的数对有多少
 */
public class CountPairs1 {
    class Solution {
        public int countPairs(int[] nums, int low, int high) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int c = nums[i] ^ nums[j];
                    if (low <= c && c <= high) {
                        result++;
                    }
                }
            }

            return result;
        }
    }
}
