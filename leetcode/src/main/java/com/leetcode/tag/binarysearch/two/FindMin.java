package com.leetcode.tag.binarysearch.two;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 画图
 */
public class FindMin {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int middle = (left + right) / 2;
                if (nums[middle] >= nums[right]) {
                    // middle肯定不是最小值
                    left = middle + 1;
                } else {
                    // middle可能是最小值
                    right = middle;
                }
            }
            return nums[left];
        }
    }
}
