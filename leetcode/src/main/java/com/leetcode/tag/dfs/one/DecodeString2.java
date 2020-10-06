package com.leetcode.tag.dfs.one;

/**
 * 394. 字符串解码
 * <p>
 * 遗忘曲线.一题多刷.
 */
public class DecodeString2 {
    class Solution {
        int current;

        public String decodeString(String s) {
            if (current >= s.length() || s.charAt(current) == ']') {
                return "";
            }
            StringBuilder result = new StringBuilder();
            if (Character.isDigit(s.charAt(current))) {
                int digit = getDigit(s);
                //移除[
                current++;
                String str = decodeString(s);
                //移除]
                current++;
                while (digit-- > 0) {
                    result.append(str);
                }

            } else if (Character.isLetter(s.charAt(current))) {
                result.append(s.charAt(current++));
            }
            return result + decodeString(s);
        }

        private int getDigit(String s) {
            int index = current;
            while (current < s.length() && Character.isDigit(s.charAt(current))) {
                current++;
            }
            return Integer.parseInt(s.substring(index, current));
        }
    }
}
