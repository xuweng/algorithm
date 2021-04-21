package com.leetcode.tag.must1.four;

/**
 * 367. 有效的完全平方数
 */
public class IsPerfectSquare {
    class Solution {
        public boolean isPerfectSquare(int num) {
            if (num < 2) {
                return true;
            }
            // 防止大数溢出
            long left = 2;
            long right = num / 2;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (num == mid * mid) {
                    return true;
                }
                if (num > mid * mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return false;
        }
    }
}
