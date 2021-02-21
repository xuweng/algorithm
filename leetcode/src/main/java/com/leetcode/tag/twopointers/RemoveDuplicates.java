package com.leetcode.tag.twopointers;

/**
 * 26. 删除排序数组中的重复项
 */
public class RemoveDuplicates {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[left] != nums[i]) {
                    nums[++left] = nums[i];
                }
            }

            return left + 1;
        }
    }
}
