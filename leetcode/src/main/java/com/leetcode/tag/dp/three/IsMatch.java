package com.leetcode.tag.dp.three;

/**
 * 10. 正则表达式匹配
 */
public class IsMatch {
    class Solution {
        public boolean isMatch(String s, String p) {
            if (p == null) {
                return s == null;
            }
            if (p.isEmpty()) {
                return s.isEmpty();
            }

            boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

            // p第1个字符是否是*
            boolean pNext = p.length() > 1 && p.charAt(1) == '*';
            if (pNext) {
                //'*' 匹配零个或多个前面的那一个元素
                return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
            } else {
                return firstMatch && isMatch(s.substring(1), p.substring(1));
            }
        }
    }
}
