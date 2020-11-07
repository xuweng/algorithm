package com.leetcode.tag.binarysearch.one;

/**
 * 69. x 的平方根
 */
public class MySqrt {
    class Solution {
        public int mySqrt(int x) {
            return (int) bs(x, 0, x);
        }

        private long bs(int x, long left, long right) {
            if (left > right) {
                return right;
            }
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                return bs(x, left, mid - 1);
            } else {
                return bs(x, mid + 1, right);
            }
        }
    }
}
