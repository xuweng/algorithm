package com.leetcode.tag.must7.one;

/**
 * 171. Excel表列序号
 */
public class TitleToNumber {
    class Solution {
        public int titleToNumber(String columnTitle) {
            int result = 0;
            for (int i = 0; i < columnTitle.length(); i++) {
                result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
            }

            return result;
        }
    }
}
