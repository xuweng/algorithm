package com.leetcode.tag.must1.two;

/**
 * 27. 移除元素
 */
public class RemoveElement {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums == null) {
                return 0;
            }
            int i = 0, j = 0;
            while (j < nums.length) {
                while (nums[j] != val) {
                    // 复制
                    nums[i++] = nums[j];
                }
                j++;
            }

            return i;
        }
    }
}
