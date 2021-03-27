package com.leetcode.tag.daily.nine;

/**
 * 44. 通配符匹配
 */
public class IsMatch {
    class Solution {
        public boolean isMatch(String s, String p) {
            if (s.isEmpty()) {
                return true;
            }
            boolean first = !p.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
            boolean next = p.length() >= 2 && p.charAt(1) == '*';
            if (next) {
                return isMatch(s, p.substring(2)) || (first && isMatch(s.substring(1), p));
            } else {
                return first && isMatch(s.substring(1), p.substring(1));
            }
        }
    }
}
