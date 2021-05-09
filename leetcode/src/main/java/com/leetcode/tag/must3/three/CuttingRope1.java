package com.leetcode.tag.must3.three;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 */
public class CuttingRope1 {
    class Solution {
        public int cuttingRope(int n) {
            if (n < 4) {
                return n - 1;
            }
            long result = 1;
            while (n > 4) {
                result *= 3;
                n -= 3;
            }

            return (int) (result * n);
        }
    }
}
