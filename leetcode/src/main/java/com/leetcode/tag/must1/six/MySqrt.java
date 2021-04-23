package com.leetcode.tag.must1.six;

/**
 * 69. x 的平方根
 */
public class MySqrt {
    class Solution {
        public int mySqrt(int x) {
            long left = 0;
            long right = x;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (mid * mid == x) {
                    return (int) mid;
                }
                if (mid * mid > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return (int) right;
        }
    }
}
