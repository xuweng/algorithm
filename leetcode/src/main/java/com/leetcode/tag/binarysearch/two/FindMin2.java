package com.leetcode.tag.binarysearch.two;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 头结点。头结点。头结点。头结点
 */
public class FindMin2 {
    class Solution {
        public int findMin(int[] nums) {
            return bs(nums, 0, nums.length - 1);
        }

        private int bs(int[] nums, int low, int high) {
            if (low > high) {
                return -1;
            }
            int mid = low + (high - low) / 2;
            if (nums[low] > nums[mid]) {
                return bs(nums, low, mid);
            } else {
                return bs(nums, mid + 1, high);
            }
        }
    }
}
