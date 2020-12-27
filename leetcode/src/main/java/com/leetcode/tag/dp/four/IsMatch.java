package com.leetcode.tag.dp.four;

import java.util.Objects;

/**
 * 10. 正则表达式匹配
 */
public class IsMatch {
    class Solution {
        /**
         * 边界条件判断
         * <p>
         * 为空的边界条件判断
         *
         * @param s
         * @param p
         * @return
         */
        public boolean isMatch(String s, String p) {
            if (p == null || s == null || p.isEmpty()) {
                return Objects.equals(p, s);
            }
            // s非空
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
