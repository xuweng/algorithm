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
        /**
         * 当区间 [i, j] 两端点的字符相同时（'aba'）：此时它的打印次数可以从它的更小一层的子区间的打印次数而来（'ab'），
         * <p>
         * 此时状态转移方程：dp[i][j] = dp[i][j - 1]；
         * <p>
         * 当区间 [i, j] 两端点的字符不同时（'abab'）：此时要遍历所有可能的组合，将该区间中的字符串进行拆分，取需要打印次数最小的解。
         * 示例：s = 'abab'
         * 先打印 'a' 再打印 'bab'，此时需要 1 + 2 = 3 次打印；
         * 先打印 'ab' 再打印 'ab'，此时需要 2 + 2 = 4 次打印；
         * 先打印 'aba' 再打印 'b'，此时需要 2 + 1 = 3 次打印，因此得到 ' abab ' 至少需要三次打印。
         *
         * @param s
         * @return
         */
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
                        for (int k = i; k < j; k++) {
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

    class Solution2 {
        /**
         * 枚举长度 + 枚举左端点 + 枚举分割点
         *
         * @param s
         * @return
         */
        public int strangePrinter(String s) {
            int n = s.length();
            int[][] f = new int[n + 1][n + 1];
            // 枚举长度
            for (int len = 1; len <= n; len++) {
                // 枚举左端点
                for (int l = 0; l + len - 1 < n; l++) {
                    // 右端点
                    int r = l + len - 1;
                    f[l][r] = f[l + 1][r] + 1;
                    // 枚举分割点 [l,r]
                    for (int k = l + 1; k <= r; k++) {
                        if (s.charAt(l) == s.charAt(k)) {
                            f[l][r] = Math.min(f[l][r], f[l][k - 1] + f[k + 1][r]);
                        }
                    }
                }
            }
            return f[0][n - 1];
        }
    }

    class Solution3 {
        public int strangePrinter(String s) {
            int n = s.length();
            if (n == 0) {
                return 0;
            }

            int[][] dp = new int[n][n];
            // 对于一个元素时，只打印一次即可。
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }

            for (int i = n - 1; i >= 0; i--) {
                // 从 i + 1 开始，往右端点(n - 1)移动，有 i < j。
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(j) == s.charAt(i)) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        int val = Integer.MAX_VALUE;
                        // 从 i 开始向 j 移动
                        // [i,j] 区间分割
                        for (int k = i; k < j; k++) {
                            val = Math.min(val, dp[i][k] + dp[k + 1][j]);
                        }
                        dp[i][j] = val;
                    }
                }
            }
            return dp[0][n - 1];
        }
    }
}
