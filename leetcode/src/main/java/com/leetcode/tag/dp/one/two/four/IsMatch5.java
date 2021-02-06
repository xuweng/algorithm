package com.leetcode.tag.dp.one.two.four;

/**
 * 10. 正则表达式匹配
 */
public class IsMatch5 {
    class Solution {
        public boolean isMatch(String s, String p) {
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            boolean first = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

            boolean next = p.length() > 1 && p.charAt(1) == '*';
            if (next) {
                return isMatch(s, p.substring(2)) || (first && isMatch(s.substring(1), p));
            } else {
                return first && isMatch(s.substring(1), p.substring(1));
            }
        }
    }
}
