package com.leetcode.tag.daily;

import java.util.ArrayDeque;
import java.util.Deque;
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

  /**
   * 作者：powcai
   * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhao-liang-bian-di-yi-ge-xiao-yu-ta-de-zhi-by-powc/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    /**
     * 是以i 为中心，向左找第一个小于 heights[i] 的位置 left_i；
     *
     * <p>向右找第一个小于于 heights[i] 的位置 right_i，即最大面积为 heights[i] * (right_i - left_i -1)
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
      if (heights == null || heights.length == 0) {
        return 0;
      }
      int n = heights.length;
      int[] leftI = new int[n];
      int[] rightI = new int[n];
      leftI[0] = -1;
      rightI[n - 1] = n;
      int res = 0;
      for (int i = 1; i < n; i++) {
        int tmp = i - 1;
        while (tmp >= 0 && heights[tmp] >= heights[i]) {
          tmp = leftI[tmp];
        }
        leftI[i] = tmp;
      }
      for (int i = n - 2; i >= 0; i--) {
        int tmp = i + 1;
        while (tmp < n && heights[tmp] >= heights[i]) {
          tmp = rightI[tmp];
        }
        rightI[i] = tmp;
      }
      for (int i = 0; i < n; i++) {
        res = Math.max(res, (rightI[i] - leftI[i] - 1) * heights[i]);
      }
      return res;
    }
  }

  /** 单调递增的栈 */
  class Solution2 {
    public int largestRectangleArea(int[] heights) {
      int res = 0;
      Deque<Integer> stack = new ArrayDeque<>();
      int[] newHeights = new int[heights.length + 2];
      // 哨兵
      newHeights[0] = 0;
      newHeights[newHeights.length - 1] = 0;

      System.arraycopy(heights, 0, newHeights, 1, heights.length + 1 - 1);
      // System.out.println(Arrays.toString(newHeights));
      for (int i = 0; i < newHeights.length; i++) {
        // System.out.println(stack.toString());
        while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
          int cur = stack.pop();
          // 出栈时计算:栈顶下标------->i
          res = Math.max(res, (i - stack.peek() - 1) * newHeights[cur]);
        }
        stack.push(i);
      }
      return res;
    }
  }

  class Solution3 {
    public int largestRectangleArea(int[] heights) {
      if (heights.length == 0) {
        return 0;
      }
      return getLargestRectangleArea(heights, 0, heights.length);
    }

    /**
     * 分治算法
     *
     * <p>类似快排。
     *
     * <p>左右两两划分。
     *
     * <p>如果排序,类似快排,point总是划分在第一个位置。是O(n2)复杂度。这里可以直接计算，不用继续划分。
     *
     * @param heights
     * @param left
     * @param right
     * @return
     */
    public int getLargestRectangleArea(int[] heights, int left, int right) {
      if (left == right) {
        return 0;
      }
      if (left == right - 1) {
        return heights[left];
      }
      // 最小高度索引
      int shortestIndex = left;
      // 是否排序
      boolean sorted = true;
      for (int i = left + 1; i < right; ++i) {
        if (heights[i] < heights[i - 1]) {
          sorted = false;
        }
        if (heights[shortestIndex] > heights[i]) {
          shortestIndex = i;
        }
      }
      // 如果[left,right]已经排序,已经不需要继续划分,可以直接计算
      if (sorted) {
        int max = 0;
        for (int i = left; i < right; i++) {
          int now = heights[i] * (right - i);
          max = Math.max(now, max);
        }
        return max;
      }
      int leftArea = getLargestRectangleArea(heights, left, shortestIndex);
      int rightArea = getLargestRectangleArea(heights, shortestIndex + 1, right);
      return Math.max(Math.max(leftArea, rightArea), (right - left) * heights[shortestIndex]);
    }
  }
}
