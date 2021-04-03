package com.leetcode.tag.must.seven;

/**
 * 面试题 17.21. 直方图的水量
 */
public class Trap {
    class Solution {
        public int trap(int[] height) {
            if (height == null) {
                return 0;
            }
            int[] left = new int[height.length];
            left[0] = height[0];
            for (int i = 1; i < height.length; i++) {
                left[i] = Math.max(left[i - 1], height[i]);
            }
            int[] right = new int[height.length];
            right[height.length - 1] = height[height.length - 1];
            for (int i = height.length - 2; i >= 0; i--) {
                right[i] = Math.max(right[i + 1], height[i]);
            }
            int result = 0;
            for (int i = 0; i < height.length; i++) {
                int min = Math.min(left[i], right[i]);
                result += min - height[i];
            }

            return result;
        }
    }
}
