package com.leetcode.tag.dp.four;

import java.util.Objects;

/**
 * 44. 通配符匹配
 */
public class IsMatch1 {
    class Solution {
        public boolean isMatch(String s, String p) {
            if (p.isEmpty() || s.isEmpty()) {
                return Objects.equals(p, s);
            }
            boolean first = s.charAt(0) == p.charAt(0) || p.charAt(0) == '?';
            if (first) {
                return isMatch(s.substring(1), p.substring(1));
            }
            if (p.charAt(0) == '*') {
                if (p.length() <= 1) {
                    return true;
                }

                if (s.charAt(0) != p.charAt(1)) {
                    return isMatch(s.substring(1), p);
                } else {
                    return isMatch(s, p.substring(1));
                }
            }

            return false;
        }
    }
}
