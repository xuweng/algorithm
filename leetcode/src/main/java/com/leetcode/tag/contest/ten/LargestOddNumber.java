package com.leetcode.tag.contest.ten;

/**
 * 5788. 字符串中的最大奇数
 */
public class LargestOddNumber {
    class Solution {
        public String largestOddNumber(String num) {
            String result = "";
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) % 2 != 0) {
                    result = num.substring(0, i + 1);
                }
            }

            return result;
        }
    }
}
