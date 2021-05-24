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
                        // 打印左侧字符 s[i] 时，可以顺便打印右侧字符 s[j]，这样我们即可忽略右侧字符对该区间的影响，
                        // 只需要考虑如何尽快打印完区间 [i,j-1]
                        f[i][j] = f[i][j - 1];
                    } else {
                        int minn = Integer.MAX_VALUE;
                        for (int k = i; k < j; k++) {
                            // 分别完成该区间的左右两部分的打印
                            // 两部分分别为区间 [i,k] 和区间 [k+1,j]
                            minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                        }
                        f[i][j] = minn;
                    }
                }
            }
            return f[0][n - 1];
        }
    }

    class Solution1 {
        public int strangePrinter(String s) {
            // f[i][j] 表示打印完成区间 [i,j] 的最少操作数
            int[][] dp = new int[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        // 打印左侧字符 s[i] 时，可以顺便打印右侧字符 s[j]，这样我们即可忽略右侧字符对该区间的影响，
                        // 只需要考虑如何尽快打印完区间 [i,j-1]
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        int minn = Integer.MAX_VALUE;
                        for (int k = i + 1; k < j; k++) {
                            // 分别完成该区间的左右两部分的打印
                            // 两部分分别为区间 [i,k] 和区间 [k+1,j]
                            minn = Math.min(minn, dp[i][k] + dp[k + 1][j]);
                        }
                        dp[i][j] = minn;
                    }
                }
            }
            return dp[0][s.length() - 1];
        }
    }
}
