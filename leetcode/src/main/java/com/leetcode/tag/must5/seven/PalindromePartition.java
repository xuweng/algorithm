package com.leetcode.tag.must5.seven;

/**
 * 1278. 分割回文串 III
 */
public class PalindromePartition {
    class Solution {
        public int palindromePartition(String s, int k) {
            if (s == null || s.length() < k) {
                return Integer.MAX_VALUE;
            }
            int n = s.length();
            char[] chars = s.toCharArray();
            // f[i][j] 表示对于字符串 S 的前 i 个字符，将它分割成 j 个非空且不相交的回文串，最少需要修改的字符数
            int[][] dp = new int[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    int pre = j == i + 1 ? 0 : dp[i + 1][j - 1];
                    dp[i][j] = chars[i] == chars[j] ? pre : pre + 1;
                }
            }
            int[][] counts = new int[n + 1][k + 1];
            for (int i = 0; i <= k; i++) {
                counts[n][i] = Integer.MAX_VALUE;
            }
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 1; j <= k; j++) {
                    counts[i][j] = Integer.MAX_VALUE;
                    if (j <= 1) {
                        counts[i][j] = dp[i][n - 1];
                    } else {
                        for (int e = i; e < n; e++) {
                            int next = counts[e + 1][j - 1];
                            counts[i][j] = Math.min(counts[i][j], next == Integer.MAX_VALUE ? next : next + dp[i][e]);
                        }
                    }
                }
            }

            return counts[0][k];
        }
    }

    /**
     * 区间dp
     */
    class Solution1 {
        public int palindromePartition(String s, int k) {
            // pali[i][j] = pali[i+1][j-1]+1(如果i和j位置的字符串不等)
            // pali[i][j] = pali[i+1][j-1] (如果i和j位置的字符串相等)
            // 注意 如果j-i<=1，即i到j之间有小于等于2个字符串的时候
            // pali[i][j] = 1(如果i和j位置的字符串不等)
            // pali[i][j] = 0(如果i和j位置的字符串相等)
            int[][] pali = new int[s.length() + 1][s.length() + 1];
            for (int i = s.length(); i >= 1; i--) {
                for (int j = i; j <= s.length(); j++) {
                    if (j - i >= 2) {
                        pali[i][j] = pali[i + 1][j - 1];
                    }
                    if (s.charAt(i - 1) != s.charAt(j - 1)) {
                        // 分割1次
                        pali[i][j]++;
                    }
                }
            }

            int[][] dp = new int[k + 1][s.length() + 1];
            // 用dp[i][j]表示，i表示切割成i个 j表示当前字符串的长度
            for (int i = 1; i <= k; i++) {
                for (int j = i; j <= s.length(); j++) {
                    if (i == 1) {
                        // 切割成1个 j表示当前字符串的长度
                        // 整个 [0,j-1]
                        dp[i][j] = pali[i][j];
                    } else {
                        // >1个
                        dp[i][j] = dp[i - 1][i - 1] + pali[i][j];
                        for (int x = i; x < j; x++) {
                            // [i-1][x] [x+1,j]
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][x] + pali[x + 1][j]);
                        }
                    }
                }
            }
            return dp[k][s.length()];
        }
    }
}
