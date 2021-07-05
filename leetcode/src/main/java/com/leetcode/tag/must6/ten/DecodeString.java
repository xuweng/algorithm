package com.leetcode.tag.must6.ten;

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

            return get();
        }

        private String get() {
            if (index >= str.length() || str.charAt(index) == ']') {
                // 终止条件
                return "";
            }
            StringBuilder result = new StringBuilder();
            char c = str.charAt(index);
            if (Character.isDigit(c)) {
                // 处理数字
                // 23[abc]8[bd]
                int d = getDigit();
                // 过滤左括号 [
                index++;
                // 获取括号内
                String s = get();
                for (int i = 0; i < d; i++) {
                    result.append(s);
                }
            } else if (Character.isLetter(c)) {
                // 处理字母
                // abc
                result.append(c);
            }
            // 过滤右括号 ]
            // 下一个
            index++;
            // 处理剩下字符串
            return result + get();
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
