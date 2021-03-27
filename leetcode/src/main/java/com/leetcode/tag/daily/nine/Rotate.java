package com.leetcode.tag.daily.nine;

/**
 * 189. 旋转数组
 */
public class Rotate {
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null) {
                return;
            }
            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                // 越界取模
                result[(i + k) % nums.length] = nums[i];
            }

            System.arraycopy(result, 0, nums, 0, nums.length);
        }
    }
}
