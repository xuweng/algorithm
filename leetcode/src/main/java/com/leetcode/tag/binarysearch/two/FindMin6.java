package com.leetcode.tag.binarysearch.two;

/**
 * 153. 寻找旋转排序数组中的最小值
 */
public class FindMin6 {
    class Solution {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return nums[left];
        }
    }
}
