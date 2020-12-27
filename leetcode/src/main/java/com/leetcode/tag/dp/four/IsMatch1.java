package com.leetcode.tag.dp.four;

/**
 * 44. 通配符匹配
 */
public class IsMatch1 {
    class Solution {
        public boolean isMatch(String s, String p) {
            boolean first = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?');
            if (first) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                if (p.charAt(0) == '*') {
                    if (p.length() > 1 && s.charAt(0) != p.charAt(1)) {
                        return isMatch(s.substring(1), p);
                    } else {
                        return isMatch(s, p.substring(1));
                    }
                }
            }
            return false;
        }
    }
}
