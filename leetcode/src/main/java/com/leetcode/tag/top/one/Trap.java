package com.leetcode.tag.top.one;

/**
 * 42. 接雨水
 * <p>
 * 结果：最长重复字符长度 + k
 */
public class Trap {
    class Solution {
        public int trap(int[] height) {
            int[] left = new int[height.length];
            int maxLeft = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > maxLeft) {
                    left[i] = height[i];
                    maxLeft = height[i];
                } else {
                    left[i] = maxLeft;
                }
            }
            int[] right = new int[height.length];
            int maxRight = 0;
            for (int i = height.length - 1; i >= 0; i--) {
                if (height[i] > maxRight) {
                    right[i] = height[i];
                    maxRight = height[i];
                } else {
                    right[i] = maxRight;
                }
            }

            int result = 0;
            for (int i = 0; i < height.length; i++) {
                result += Math.min(left[i], right[i]) - height[i];
            }

            return result;
        }
    }
}
