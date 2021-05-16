package com.leetcode.tag.contest.four;

/**
 * 5760. 构成交替字符串需要的最小交换次数
 */
public class MinSwaps {
    class Solution {
        public int minSwaps(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            int count = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) != s.charAt(i)) {
                    count++;
                }
            }
            if (count == s.length() - 1) {
                return 0;
            }

            return 0;
        }
    }
}
