package com.leetcode.tag.must7.three;

/**
 * 70. 爬楼梯
 */
public class ClimbStairs {
    class Solution {
        public int climbStairs(int n) {
            if (n == 1 || n == 0) {
                return 1;
            }

            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}
