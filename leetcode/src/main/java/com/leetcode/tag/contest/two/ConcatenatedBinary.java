package com.leetcode.tag.contest.two;

/**
 * 5620. 连接连续二进制数字
 */
public class ConcatenatedBinary {
    /**
     * 大数溢出
     */
    class Solution {
        public int concatenatedBinary(int n) {
            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                result.append(Integer.toBinaryString(i));
            }
            // 大数溢出
            return (int) (Long.valueOf(result.toString(), 2) % (Math.pow(10, 9) + 7));
        }
    }
}
