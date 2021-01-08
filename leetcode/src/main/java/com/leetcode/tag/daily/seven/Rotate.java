package com.leetcode.tag.daily.seven;

/**
 * 189. 旋转数组
 */
public class Rotate {
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return;
            }
            for (int i = 0; i < k; i++) {
                int x = nums[nums.length - 1];
                System.arraycopy(nums, 0, nums, 1, nums.length - 2 + 1);
                nums[0] = x;
            }

        }
    }
}
