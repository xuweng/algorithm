package com.leetcode.tag.daily.four;

/**
 * 844. 比较含退格的字符串
 */
public class BackspaceCompare {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            StringBuilder stringBuilder = new StringBuilder(S);
            StringBuilder s = new StringBuilder(T);

            dfs(stringBuilder, 0);
            dfs(s, 0);

            return stringBuilder.toString().equals(s.toString());
        }

        private void dfs(StringBuilder s, int index) {
            if (index >= s.length() || index == -1 || s.indexOf("#") == -1) {
                return;
            }
            if (s.charAt(index) == '#') {
                if (index >= 1) {
                    s.delete(index - 1, index);
                } else {
                    s.deleteCharAt(index);
                }
                dfs(s, s.indexOf("#"));
            } else {
                dfs(s, index + 1);
            }
        }
    }
}
