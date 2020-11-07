package com.leetcode.tag.binarysearch.one;

/**
 * 69. x 的平方根
 */
public class MySqrt {
    class Solution {
        public int mySqrt(int x) {
            return bs(x, 0, x);
        }

        private int bs(int x, int left, int right) {
            if (left > right) {
                return right;
            }
            int mid = left + (right - left) / 2;
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
