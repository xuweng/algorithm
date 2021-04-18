package com.leetcode.tag.must1.two;

/**
 * 283. 移动零
 */
public class MoveZeroes {
    class Solution {
        public void moveZeroes(int[] nums) {
            if (nums == null) {
                return;
            }
            int i = 0, j = 0;
            while (j < nums.length) {
                if (nums[j] != 0) {
                    // 复制
                    nums[i++] = nums[j];
                }
                j++;
            }
            while (i < nums.length) {
                nums[i++] = 0;
            }
        }
    }
}
