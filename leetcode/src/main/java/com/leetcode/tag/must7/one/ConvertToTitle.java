package com.leetcode.tag.must7.one;

/**
 * 168. Excel表列名称
 */
public class ConvertToTitle {
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder stringBuilder = new StringBuilder();
            while (columnNumber > 0) {
                columnNumber--;

                stringBuilder.append((char) (columnNumber % 26 + 'A'));

                columnNumber = columnNumber / 26;
            }

            return stringBuilder.reverse().toString();
        }
    }
}
