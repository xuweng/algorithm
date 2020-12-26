package com.leetcode.tag.stack;

import java.util.Arrays;
import java.util.Stack;

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

    /**
     * 方法一：单调栈
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
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
     * 方法二：单调栈 + 常数优化
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right, n);

            Stack<Integer> monoStack = new Stack<>();
            for (int i = 0; i < n; ++i) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    right[monoStack.peek()] = i;
                    monoStack.pop();
                }
                left[i] = (monoStack.isEmpty() ? -1 : monoStack.peek());
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
