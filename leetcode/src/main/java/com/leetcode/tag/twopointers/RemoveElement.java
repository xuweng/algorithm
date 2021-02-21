package com.leetcode.tag.twopointers;

/**
 * 27. 移除元素
 */
public class RemoveElement {
    class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[left++] = nums[i];
                }
            }

            return left;
        }
    }
}
