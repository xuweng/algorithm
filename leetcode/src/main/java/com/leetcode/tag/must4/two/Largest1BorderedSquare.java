package com.leetcode.tag.must4.two;

/**
 * 1139. 最大的以 1 为边界的正方形
 */
public class Largest1BorderedSquare {
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int M = grid.length;
            int N = grid[0].length;
            //两个预处理矩阵，表示从右下角开始，横向多少个连续的1和竖向多少个连续的1
            int[][] right = new int[M][N];
            int[][] down = new int[M][N];
            for (int i = M - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    if (grid[i][j] == 1) {
                        right[i][j] = 1;
                        down[i][j] = 1;
                        if (j != N - 1) {
                            right[i][j] += right[i][j + 1];
                        }
                        if (i != M - 1) {
                            down[i][j] += down[i + 1][j];
                        }
                    }
                }
            }
            int res = 0;
            for (int row = 0; row < M; row++) {
                for (int col = 0; col < N; col++) {
                    //两个循环挨个找点，再更具点枚举边长
                    for (int border = 1; border <= Math.min(M - row, N - col); border++) {
                        //该点的right和down都是大于等于边长的，说明连续的1才够。四条边都要判断
                        if (right[row][col] >= border
                                && down[row][col] >= border
                                && down[row][col + border - 1] >= border
                                && right[row + border - 1][col] >= border) {
                            res = Math.max(res, border);
                        }
                    }
                }
            }
            return res * res;
        }
    }

    class Solution1 {
        public int largest1BorderedSquare(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            // dp[i][j][0]: i,j左边连续的1的个数
            // dp[i][j][1]: i,j上边连续的1的个数
            int[][][] dp = new int[m + 1][n + 1][2];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (grid[i - 1][j - 1] == 1) {
                        dp[i][j][0] = 1 + dp[i][j - 1][0];
                        dp[i][j][1] = 1 + dp[i - 1][j][1];
                    }
                }
            }
            int res = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    //最短的那条边不一定是合法的边长，如果该边长不合法就需要缩减边长，直到找到合法的
                    for (int side = Math.min(dp[i][j][0], dp[i][j][1]); side >= 1; side--) {
                        if (dp[i][j - side + 1][1] >= side && dp[i - side + 1][j][0] >= side) {
                            res = Math.max(res, side);
                            break; //更短的就没必要考虑了
                        }
                    }
                }
            }
            return res * res;
        }
    }
}
