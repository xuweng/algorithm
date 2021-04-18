package com.leetcode.tag.must1.two;

/**
 * 26. 删除有序数组中的重复项
 */
public class RemoveDuplicates {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int i = 0, j = 0;
            while (j < nums.length) {
                while (nums[i] != nums[j]) {
                    // 复制
                    nums[++i] = nums[j];
                }
                j++;
            }

            return i + 1;
        }
    }
}
