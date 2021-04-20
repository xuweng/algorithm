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
            // 大数溢出
            long left = 0;
            long right = x;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (x == mid * mid) {
                    return (int) mid;
                }
                if (x > mid * mid) {
                    // left可能=mid left一般要改变
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return (int) right;
        }
    }
}
