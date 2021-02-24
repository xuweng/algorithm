package com.leetcode.tag.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 */
public class LongestValidParentheses {
    class Solution {
        public int longestValidParentheses(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int max = 0;
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    deque.push(i);
                } else {
                    if (!deque.isEmpty()) {
                        max = Math.max(max, i - deque.peek() + 1);
                        deque.pop();
                    }
                }
            }

            return max;
        }
    }
}
