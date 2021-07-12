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

    class Solution1 {
        public int climbStairs(int n) {
            if (n == 1 || n == 0) {
                return 1;
            }

            int p1 = 1;
            int p2 = 1;
            int p3 = 0;
            for (int i = 2; i <= n; i++) {
                p3 = p1 + p2;

                p1 = p2;
                p2 = p3;
            }

            return p3;
        }
    }
}
