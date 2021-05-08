package com.leetcode.tag.must3.two;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 */
public class CuttingRope1 {
    class Solution {
        public int cuttingRope(int n) {
            if (n < 4) {
                return n - 1;
            }
            int result = 1;
            while (n > 4) {
                result = result * 3 % 1000000007;
                n -= 3;
            }

            return result * n % 1000000007;
        }
    }
}
