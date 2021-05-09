package com.leetcode.tag.must3.three;

/**
 * 剑指 Offer 13. 机器人的运动范围
 */
public class MovingCount {
    class Solution {
        public int movingCount(int m, int n, int k) {
            if (k == 0) {
                return 1;
            }
            boolean[][] dp = new boolean[m][n];
            dp[0][0] = true;
            int count = 1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 不能进入行坐标和列坐标的数位之和大于k的格子
                    if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                        continue;
                    }
                    // 上一行
                    if (i - 1 >= 0) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    // 左一列
                    if (j - 1 > 0) {
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }
                    count += dp[i][j] ? 1 : 0;
                }
            }

            return count;
        }

        private int get(int i) {
            int result = 0;
            while (i != 0) {
                // 123 3+2+1=6
                result += i % 10;
                i = i / 10;
            }

            return result;
        }
    }
}
