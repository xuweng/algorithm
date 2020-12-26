package com.leetcode.tag.stack;

/**
 * 84. 柱状图中最大的矩形
 */
public class LargestRectangleArea {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0) {
                return 0;
            }
            int max = 0;
            for (int i = 0; i < heights.length; i++) {
                int leftIndex = i - 1;
                int left = 0;
                while (leftIndex >= 0 && heights[leftIndex] >= heights[i]) {
                    left++;
                    leftIndex--;
                }
                int rightIndex = i + 1;
                int right = 0;
                while (rightIndex < heights.length && heights[rightIndex] >= heights[i]) {
                    right++;
                    rightIndex++;
                }
                max = Math.max(max, (left + right + 1) * heights[i]);
            }
            return max;
        }
    }
}
