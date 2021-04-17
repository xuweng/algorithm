package com.leetcode.tag.must1.one;

/**
 * 415. 字符串相加
 */
public class AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {
            if (num1 == null || num2 == null) {
                return null;
            }
            int jin = 0;
            int i = num1.length() - 1, j = num2.length() - 1;
            StringBuilder stringBuilder = new StringBuilder();
            while (i >= 0 || j >= 0) {
                int v1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int v2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int sum = v1 + v2 + jin;
                stringBuilder.append(sum % 10);
                jin = sum / 10;
                i--;
                j--;
            }
            if (jin > 0) {
                stringBuilder.append(jin);
            }
            return stringBuilder.reverse().toString();
        }
    }
}
