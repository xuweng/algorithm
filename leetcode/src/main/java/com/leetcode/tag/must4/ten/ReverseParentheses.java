package com.leetcode.tag.must4.ten;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1190. 反转每对括号间的子串
 */
public class ReverseParentheses {
    class Solution {
        int index;

        public String reverseParentheses(String s) {
            if (s == null || s.isEmpty()) {
                return s;
            }

            return dfs(s, "");
        }

        private String dfs(String s, String temp) {
            if (index >= s.length()) {
                return temp;
            }
            if (Character.isLetter(s.charAt(index))) {
                return dfs(s, temp + s.charAt(index++));
            } else if (s.charAt(index) == '(') {
                index++;
                return temp + dfs(s, "");
            } else if (s.charAt(index) == ')') {
                index++;
                return dfs(s, re(temp));
            }

            return "";
        }

        private String re(String s) {
            char[] chars = s.toCharArray();
            int i = 0;
            int j = chars.length - 1;

            while (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;

                i++;
                j--;
            }

            return new String(chars);
        }
    }

    class Solution1 {
        public String reverseParentheses(String s) {
            Deque<String> stack = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.push(sb.toString());
                    sb.setLength(0);
                } else if (ch == ')') {
                    sb.reverse();
                    sb.insert(0, stack.pop());
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }
}
