package com.leetcode.tag.must2;

import java.util.Arrays;

/**
 * 1289. 下降路径最小和  II
 */
public class MinFallingPathSum1 {
    class Solution {
        public int minFallingPathSum(int[][] arr) {
            int m = arr.length;
            int n = arr[0].length;
            int[][] dp = new int[m][n];

            // 最小值列
            int index1;
            // 次小值列
            int index2;
            if (arr[0][0] <= arr[0][1]) {
                index1 = 0;
                index2 = 1;
            } else {
                index1 = 1;
                index2 = 0;
            }

            for (int i = 0; i < m; i++) {
                // 记录上一层
                int i1 = index1;
                int i2 = index2;
                // 计算本层
                if (arr[i][0] <= arr[i][1]) {
                    index1 = 0;
                    index2 = 1;
                } else {
                    index1 = 1;
                    index2 = 0;
                }

                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        dp[i][j] = arr[i][j];
                        if (j > 1) {
                            if (dp[i][index1] > dp[i][j]) {
                                index1 = j;
                                index2 = index1;
                            } else if (dp[i][index2] > dp[i][j]) {
                                index2 = j;
                            }
                        }
                        continue;
                    }
                    if (j == i1) {
                        dp[i][j] = dp[i - 1][i2] + arr[i][j];
                    } else {
                        dp[i][j] = dp[i - 1][i1] + arr[i][j];
                    }
                    if (j > 1) {
                        if (dp[i][index1] > dp[i][j]) {
                            index1 = j;
                            index2 = index1;
                        } else if (dp[i][index2] > dp[i][j]) {
                            index2 = j;
                        }
                    }
                }
            }

            return Arrays.stream(dp[m - 1]).min().getAsInt();
        }
    }

    class Solution1 {
        public int minFallingPathSum(int[][] arr) {
            int m = arr.length;
            int n = arr[0].length;

            // 最小值列
            int min1;
            // 次小值列
            int min2;
            if (arr[0][0] <= arr[0][1]) {
                min1 = 0;
                min2 = 1;
            } else {
                min1 = 1;
                min2 = 0;
            }

            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                // 记录上一层
                int index = min1;
                int index1 = min2;
                // 计算本层
                if (arr[i][0] <= arr[i][1]) {
                    min1 = 0;
                    min2 = 1;
                } else {
                    min1 = 1;
                    min2 = 0;
                }

                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        dp[i][j] = arr[i][j];
                        if (j > 1) {
                            if (dp[i][min1] > dp[i][j]) {
                                min2 = min1;
                                min1 = j;
                            } else if (dp[i][min2] > dp[i][j]) {
                                min2 = j;
                            }
                        }

                        continue;
                    }
                    if (j == index) {
                        dp[i][j] = dp[i - 1][index1] + arr[i][j];
                    } else {
                        dp[i][j] = dp[i - 1][index] + arr[i][j];
                    }
                    // 更新
                    if (j > 1) {
                        if (dp[i][min1] > dp[i][j]) {
                            min2 = min1;
                            min1 = j;
                        } else if (dp[i][min2] > dp[i][j]) {
                            min2 = j;
                        }
                    }
                }
            }

            return Arrays.stream(dp[m - 1]).min().getAsInt();
        }
    }
}
