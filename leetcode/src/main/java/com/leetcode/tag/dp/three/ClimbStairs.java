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

        /**
         * n最大为45.超过会大数溢出.
         *
         * @param n
         * @return
         */
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

    /**
     * 递归+备忘录=dp
     */
    class Solution1 {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }
}
