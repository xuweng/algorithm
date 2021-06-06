package com.leetcode.tag.must6.one;

/**
 * 35. 搜索插入位置
 * <p>
 * ij模型 ij模型 ij模型
 * <p>
 * left越界 left越界 left越界
 * <p>
 * 倒序 倒序 倒序 倒序
 */
public class SearchInsert {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }
}
