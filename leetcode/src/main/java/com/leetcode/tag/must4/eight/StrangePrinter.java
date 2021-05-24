package com.leetcode.tag.must4.eight;

/**
 * 664. 奇怪的打印机
 */
public class StrangePrinter {
    /**
     * 方法一：动态规划
     */
    class Solution {
        public int strangePrinter(String s) {
            int n = s.length();
            // f[i][j] 表示打印完成区间 [i,j] 的最少操作数
            int[][] f = new int[n][n];
            for (int i = n - 1; i >= 0; i--) {
                // f[i][i]=1，对于长度为 1 的区间，需要打印 1 次
                f[i][i] = 1;
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        f[i][j] = f[i][j - 1];
                    } else {
                        int minn = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++) {
                            minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                        }
                        f[i][j] = minn;
                    }
                }
            }
            return f[0][n - 1];
        }
    }
}
