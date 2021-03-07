package com.leetcode.tag.contest.two;

/**
 * 5697. 检查二进制字符串字段
 */
public class CheckOnesSegment {
    class Solution {
        public boolean checkOnesSegment(String s) {
            if (s == null || s.isEmpty()) {
                return false;
            }
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    if (s.charAt(i - 1) == '0') {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
