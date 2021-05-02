package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Search {
    static class Solution {
        public int search(int[] nums, int target) {
            int left = getLeft(nums, target);
            if (left == -1) {
                return 0;
            }
            int right = getRight(nums, target);

            return right - left + 1;
        }

        private int getLeft(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                // 两个数时，mid=第一个
                int mid = left + (right - left) / 2;
                if (target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 搜索不到
            if (nums[left] != target) {
                return -1;
            }

            return right;
        }

        private int getRight(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                // 两个数时，mid=第二个
                int mid = left + (right - left + 1) / 2;
                if (target >= nums[mid]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        solution.search(nums, target);
    }
}
