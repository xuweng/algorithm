package com.leetcode.tag.must.one.three;

/**
 * 189. 旋转数组
 */
public class Rotate {
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null) {
                return;
            }
            int[] n = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                n[(i + k) % nums.length] = nums[i];
            }

            System.arraycopy(n, 0, nums, 0, n.length);
        }
    }
}
