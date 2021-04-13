package com.leetcode.tag.must.seven;

/**
 * 375. 猜数字大小 II
 */
public class GetMoneyAmount {
    public class Solution {
        public int getMoneyAmount(int n) {
            // dp(i, j) 代表在 (i, j) 中最坏情况下最小开销的代价
            // cost(i,j)=pivot+max(cost(i,pivot−1),cost(pivot+1,n))
            int[][] dp = new int[n + 1][n + 1];
            for (int len = 2; len <= n; len++) {
                for (int start = 1; start <= n - len + 1; start++) {
                    int minres = Integer.MAX_VALUE;
                    for (int piv = start; piv < start + len - 1; piv++) {
                        int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                        minres = Math.min(res, minres);
                    }
                    dp[start][start + len - 1] = minres;
                }
            }
            return dp[1][n];
        }
    }
}
