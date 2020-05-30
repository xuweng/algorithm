package com.leetcode.tag.daily;

import java.util.Stack;

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

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 栈中存放了 j 值。从栈底到栈顶，j 的值严格单调递增，同时对应的高度值也严格单调递增；
     *
     * <p>当我们枚举到第 i 根柱子时，我们从栈顶不断地移除height[j]≥height[i] 的
     *
     * <p>j 值。在移除完毕后，栈顶的 j 值就一定满足 height[j]<height[i]，此时 j就是
     *
     * <p>i 左侧且最近的小于其高度的柱子。
     *
     * <p>栈中存放的元素具有单调性，这就是经典的数据结构「单调栈」了。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
      int n = heights.length;
      int[] left = new int[n];
      int[] right = new int[n];

      Stack<Integer> monoStack = new Stack<>();
      for (int i = 0; i < n; ++i) {
        while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
          monoStack.pop();
        }
        left[i] = (monoStack.isEmpty() ? -1 : monoStack.peek());
        monoStack.push(i);
      }

      monoStack.clear();
      for (int i = n - 1; i >= 0; --i) {
        while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
          monoStack.pop();
        }
        right[i] = (monoStack.isEmpty() ? n : monoStack.peek());
        monoStack.push(i);
      }

      int ans = 0;
      for (int i = 0; i < n; ++i) {
        ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
      }
      return ans;
    }
  }
}
