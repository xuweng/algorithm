package com.leetcode.tag.contest.two;

import java.util.Arrays;

/**
 * 5618. K 和数对的最大数目
 */
public class MaxOperations {
    class Solution {
        public int maxOperations(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int result = 0;
            int left = 0, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == k) {
                    result++;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > k) {
                    right--;
                } else {
                    left++;
                }
            }

            return result;

        }
    }
}
