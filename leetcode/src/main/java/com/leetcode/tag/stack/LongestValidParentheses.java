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

    /**
     * 子序列 字串 相等 配匹
     * <p>
     * 方法一：动态规划
     * <p>
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            //定义 dp[i] 表示以下标 i 字符结尾的最长有效括号的长度
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            return maxans;
        }
    }

}
