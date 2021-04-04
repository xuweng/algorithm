package com.leetcode.tag.must.eight;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 */
public class FindMin1 {
    class Solution {
        public int findMin(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                    right--;
                } else if (nums[mid] <= nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return -1;
        }
    }
}
