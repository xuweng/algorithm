package com.leetcode.tag.daily;

/**
 * 84. 柱状图中最大的矩形
 */
public class LargestRectangleArea {
  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    int max = 0;
    for (int i = 0; i < heights.length; i++) {
      int left = i;
      while (left >= 0 && heights[i] <= heights[left]) {
        left--;
      }
      int right = i;
      while (right < heights.length && heights[i] <= heights[right]) {
        right++;
      }
      max = Math.max(max, heights[i] * (right - left - 1));
    }

    return max;
  }
}
