package com.leetcode.tag.must1.three;

/**
 * 69. x 的平方根
 */
public class MySqrt {
    class Solution {
        public int mySqrt(int x) {
            if (x < 0) {
                return 1 / mySqrt(-x);
            }
            int left = 0;
            int right = x;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (x == mid * mid) {
                    return mid;
                }
                if (x > mid * mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return right;
        }
    }
}
