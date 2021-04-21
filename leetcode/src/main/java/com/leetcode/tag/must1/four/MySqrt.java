package com.leetcode.tag.must1.four;

/**
 * 69. x 的平方根
 */
public class MySqrt {
    class Solution {
        public int mySqrt(int x) {
            int left = 0;
            int right = x;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid * mid == x) {
                    return mid;
                }
                if (mid * mid > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return right;
        }
    }
}
