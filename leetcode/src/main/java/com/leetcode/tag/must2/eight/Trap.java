package com.leetcode.tag.must2.eight;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 */
public class Trap {
    class Solution {
        public int trap(int[] height) {
            if (height.length == 0) {
                return 0;
            }
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

    class Solution1 {
        public int trap(int[] height) {
            int ans = 0;
            // 单调递减栈
            Deque<Integer> stack = new LinkedList<>();
            int n = height.length;
            for (int i = 0; i < n; ++i) {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    // top最小
                    int top = stack.pop();
                    if (stack.isEmpty()) {
                        break;
                    }
                    // left < top < height[i]
                    int left = stack.peek();
                    // 宽度
                    int currWidth = i - left - 1;
                    // 高度
                    int currHeight = Math.min(height[left], height[i]) - height[top];
                    ans += currWidth * currHeight;
                }
                stack.push(i);
            }
            return ans;
        }
    }
}
