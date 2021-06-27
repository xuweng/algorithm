package com.leetcode.tag.must6.nine;

/**
 * 剑指 Offer 15. 二进制中1的个数
 */
public class HammingWeight {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count++;
                n = n & (n - 1);
            }

            return count;
        }
    }
}
