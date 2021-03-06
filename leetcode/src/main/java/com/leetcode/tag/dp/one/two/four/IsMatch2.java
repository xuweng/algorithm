package com.leetcode.tag.dp.one.two.four;

/**
 * 10. 正则表达式匹配
 */
public class IsMatch2 {
    class Solution {
        public boolean isMatch(String s, String p) {
            // 只需要p非空
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            // s必须非空
            boolean first = !s.isEmpty() && ((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.');
            boolean next = p.length() > 1 && p.charAt(1) == '*';
            if (next) {
                return isMatch(s, p.substring(2)) || (first && isMatch(s.substring(1), p));
            } else {
                return first && isMatch(s.substring(1), p.substring(1));
            }
        }
    }
}
