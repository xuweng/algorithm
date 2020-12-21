package com.leetcode.tag.dp.three;

/**
 * 70. 爬楼梯
 */
public class ClimbStairs {
    class Solution {
        long[] meno;

        public int climbStairs(int n) {
            meno = new long[n + 1];
            return (int) back(n);
        }

        private long back(int n) {
            if (n < 0) {
                return 0;
            }
            if (n == 1 || n == 0) {
                return 1;
            }
            if (meno[n] != 0) {
                return meno[n];
            }
            meno[n] = back(n - 1) + back(n - 2);
            return meno[n];
        }
    }
}
