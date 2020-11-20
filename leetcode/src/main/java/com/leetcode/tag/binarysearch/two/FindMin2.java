package com.leetcode.tag.binarysearch.two;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 头结点。头结点。头结点。头结点
 */
public class FindMin2 {
    static class Solution {
        public int findMin(int[] nums) {
            return bs(nums, 0, nums.length - 1);
        }

        /**
         * 取nums[low]还是nums[high]?
         *
         * @param nums
         * @param low
         * @param high
         * @return
         */
        private int bs(int[] nums, int low, int high) {
            if (low > high) {
                return -1;
            }
            int mid = low + (high - low) / 2;
            if (low == mid) {
                return low;
            }
            if (nums[mid] > nums[high]) {
                return bs(nums, mid + 1, high);
            } else {
                return bs(nums, low, mid);
            }
        }
    }
}
