package com.leetcode.tag.must2.eight;

/**
 * 42. 接雨水
 */
public class Trap {
    class Solution {
        public int trap(int[] height) {
            int[] left = new int[height.length];
            left[0] = height[0];
            for (int i = 1; i < height.length; i++) {
                left[i] = Math.max(left[i - 1], height[i]);
            }
            int[] right = new int[height.length];
            right[right.length - 1] = height[height.length - 1];
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
