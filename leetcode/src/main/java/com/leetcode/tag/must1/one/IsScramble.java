package com.leetcode.tag.must1.one;

/**
 * 87. 扰乱字符串
 */
public class IsScramble {
    class Solution {
        public boolean isScramble(String s1, String s2) {
            if (s1 == null || s2 == null) {
                return false;
            }
            int m = s1.length();
            int n = s2.length();
            if (m != n) {
                return false;
            }
            boolean[][][] dp = new boolean[m][m][m + 1];
            // 初始化长度为1
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
                }
            }
            // 枚举长度
            for (int len = 2; len <= m; len++) {
                // 枚举i
                for (int i = 0; i <= m - len; i++) {
                    // 枚举j
                    for (int j = 0; j <= m - len; j++) {
                        // 枚举分割点 长度的分割点
                        for (int k = 1; k < len; k++) {
                            // 不交换
                            if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
                                dp[i][j][len] = true;
                                break;
                            }
                            // 交换
                            if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                                dp[i][j][len] = true;
                                break;
                            }
                        }
                    }
                }
            }

            return dp[0][0][m];
        }
    }
}
