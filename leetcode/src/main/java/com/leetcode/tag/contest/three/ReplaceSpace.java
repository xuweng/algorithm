package com.leetcode.tag.contest.three;

/**
 * 剑指 Offer 05. 替换空格
 */
public class ReplaceSpace {
    static class Solution {
        public String replaceSpace(String s) {
            char[] chars = s.toCharArray();
            int count = 0;
            for (char aChar : chars) {
                if (aChar == ' ') {
                    count++;
                }
            }

            int len = chars.length + 2 * count;
            char[] result = new char[len];
            int index = len - 1;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == ' ') {
                    result[index--] = '0';
                    result[index--] = '2';
                    result[index--] = '%';
                } else {
                    result[index--] = chars[i];
                }
            }

            return new String(result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.replaceSpace("We are happy.");
    }
}
