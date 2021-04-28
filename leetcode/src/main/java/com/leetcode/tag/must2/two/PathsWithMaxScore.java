package com.leetcode.tag.must2.two;

import java.util.List;

/**
 * 1301. 最大得分的路径数目
 */
public class PathsWithMaxScore {
    class Solution {
        int mod = 1000000007;

        public int[] pathsWithMaxScore(List<String> board) {
            int m = board.size();
            int n = board.get(0).length();
            char[][] chars = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    chars[i][j] = board.get(i).charAt(j);
                }
            }

            int[][] dp = new int[m][n];
            int[][] max = new int[m][n];
            max[m - 1][n - 1] = 1;

            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (i == m - 1 && j == n - 1) {
                        continue;
                    }
                    dp[i][j] = Integer.MIN_VALUE;
                    if (chars[i][j] == 'X') {
                        continue;
                    }
                    int cur = (i == 0 && j == 0) ? 0 : chars[i][j] - '0';
                    // 下一行
                    if (i + 1 < m) {
                        if (dp[i][j] < cur + dp[i + 1][j]) {
                            dp[i][j] = cur + dp[i + 1][j];
                            max[i][j] = max[i + 1][j];
                        } else if (dp[i][j] == cur + dp[i + 1][j]) {
                            // 方案数累加
                            max[i][j] += max[i + 1][j];
                        }
                    }
                    dp[i][j] %= mod;
                    // 右一列
                    if (j + 1 < n) {
                        if (dp[i][j] < cur + dp[i][j + 1]) {
                            dp[i][j] = cur + dp[i][j + 1];
                            max[i][j] = max[i][j + 1];
                        } else if (dp[i][j] == cur + dp[i][j + 1]) {
                            // 方案数累加
                            max[i][j] += max[i][j + 1];
                        }
                    }
                    dp[i][j] %= mod;
                    // 右对角线
                    if (i + 1 < m && j + 1 < n) {
                        if (dp[i][j] < cur + dp[i + 1][j + 1]) {
                            dp[i][j] = cur + dp[i + 1][j + 1];
                            max[i][j] = max[i + 1][j + 1];
                        } else if (dp[i][j] == cur + dp[i + 1][j + 1]) {
                            // 方案数累加
                            max[i][j] += max[i + 1][j + 1];
                        }
                    }
                    dp[i][j] %= mod;
                }
            }
            return new int[]{Math.max(dp[0][0], 0), max[0][0]};
        }
    }
}
