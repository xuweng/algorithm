package com.leetcode.tag.must1.six;

/**
 * 367. 有效的完全平方数
 */
public class IsPerfectSquare {
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }
            int left = 2;
            int right = num / 2;
            while (left <= right) {
                int mid = left + (right - left) / 2;
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
