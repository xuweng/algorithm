package com.leetcode.tag.must1.five;

/**
 * 367. 有效的完全平方数
 */
public class IsPerfectSquare {
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }
            long left = 2;
            long right = num / 2;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (mid * mid == num) {
                    return true;
                }
                if (mid * mid > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return false;
        }
    }
}
