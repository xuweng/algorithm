package com.leetcode.tag.must.seven;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null) {
                return new int[]{};
            }
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    int i = mid;
                    int j = mid;
                    while (i >= 0 && nums[i] == target) {
                        i--;
                    }
                    while (j < nums.length && nums[j] == target) {
                        j++;
                    }
                    return new int[]{i + 1, j - 1};
                }
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return new int[]{-1, -1};
        }
    }

    /**
     * 两次二分
     */
    class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return new int[]{-1, -1};
            }

            int firstPosition = findFirstPosition(nums, target);
            if (firstPosition == -1) {
                return new int[]{-1, -1};
            }

            int lastPosition = findLastPosition(nums, target);
            return new int[]{firstPosition, lastPosition};
        }

        private int findFirstPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 小于一定不是解
                if (nums[mid] < target) {
                    // 下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    // 下一轮搜索区间是 [left, mid]
                    right = mid;
                } else {
                    // nums[mid] > target，下一轮搜索区间是 [left, mid - 1]
                    right = mid - 1;
                }
            }

            if (nums[left] == target) {
                return left;
            }
            return -1;
        }

        private int findLastPosition(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > target) {
                    // 下一轮搜索区间是 [left, mid - 1]
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    // 下一轮搜索区间是 [mid, right]
                    left = mid;
                } else {
                    // nums[mid] < target，下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
