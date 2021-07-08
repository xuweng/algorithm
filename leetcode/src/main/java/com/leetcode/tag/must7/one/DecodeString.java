package com.leetcode.tag.must7.one;

/**
 * 394. 字符串解码
 */
public class DecodeString {
    class Solution {
        int index;
        String str;

        public String decodeString(String s) {
            if (s == null || s.isEmpty()) {
                return s;
            }
            str = s;

            return dfs();
        }

        private String dfs() {
            if (index >= str.length() || str.charAt(index) == ']') {
                return "";
            }
            StringBuilder result = new StringBuilder();
            char c = str.charAt(index);
            if (Character.isDigit(c)) {
                // 23[abc]
                // 处理数字
                int digit = getDigit();
                // 过滤左括号
                index++;
                // 获取括号内
                String dfs = dfs();
                for (int i = 0; i < digit; i++) {
                    result.append(dfs);
                }
            } else if (Character.isLetter(c)) {
                // abc
                // 处理字母
                result.append(c);
            }
            // 过滤右括号
            // 下一个字母
            index++;
            // 处理剩下
            return result + dfs();
        }

        private int getDigit() {
            int result = 0;
            while (index < str.length() && Character.isDigit(str.charAt(index))) {
                result = result * 10 + (str.charAt(index) - '0');
                index++;
            }

            return result;
        }
    }
}
