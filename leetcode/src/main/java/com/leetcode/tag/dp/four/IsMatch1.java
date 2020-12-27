package com.leetcode.tag.dp.four;

/**
 * 44. 通配符匹配
 */
public class IsMatch1 {
    class Solution {
        public boolean isMatch(String s, String p) {
            // 只需要p非空判断
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            // s另外非空判断
            boolean first = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?');
            if (first) {
                return isMatch(s.substring(1), p.substring(1));
            }
            if (p.charAt(0) == '*') {
                if (p.length() <= 1) {
                    return true;
                }

                if (!s.isEmpty() && s.charAt(0) != p.charAt(1)) {
                    return isMatch(s.substring(1), p);
                } else {
                    return isMatch(s, p.substring(1)) || (!s.isEmpty() && isMatch(s.substring(1), p));
                }
            }

            return false;
        }
    }
}
