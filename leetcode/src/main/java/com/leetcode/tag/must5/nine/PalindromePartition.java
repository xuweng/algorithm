package com.leetcode.tag.must5.nine;

/**
 * 1278. 分割回文串 III
 * <p>
 * 前缀和+hash
 * <p>
 * 前缀和+dp
 * <p>
 * 前缀和+hash
 * <p>
 * 前缀和+dp
 */
public class PalindromePartition {
    class Solution {
        public int palindromePartition(String s, int k) {
            // 不分割
            // 长度 长度 长度
            int[][] ints = new int[s.length() + 1][s.length() + 1];
            int[][] dp = new int[s.length() + 1][k + 1];
            for (int i = s.length(); i >= 1; i--) {
                for (int j = i + 1; j <= s.length(); j++) {
                    ints[i][j] = ints[i + 1][j - 1];
                    if (s.charAt(i - 1) != s.charAt(j - 1)) {
                        // 修改一次
                        ints[i][j]++;
                    }
                    dp[i][j] = ints[i][j];
                }
            }

            for (int i = 1; i <= s.length(); i++) {
                for (int x = 1; x < i; x++) {
                    int min = Integer.MAX_VALUE;
                    // 两段
                    // [0,x-1] [x,i-1]
                    // k在这里遍历不能赋值
                    for (int j = 1; j <= k; j++) {
                        dp[i][j] = Math.min(min, dp[x][j - 1] + ints[x + 1][i]);
                    }
                }
            }

            return dp[s.length()][k];
        }
    }

    class Solution1 {
        public int palindromePartition(String s, int k) {
            // pali[i][j] = pali[i+1][j-1]+1(如果i和j位置的字符串不等)
            // pali[i][j] = pali[i+1][j-1] (如果i和j位置的字符串相等)
            // 注意 如果j-i<=1，即i到j之间有小于等于2个字符串的时候
            // pali[i][j] = 1(如果i和j位置的字符串不等)
            // pali[i][j] = 0(如果i和j位置的字符串相等)

            // 计算切割成1个，长度为j 每个区间 的最小
            int[][] pali = new int[s.length() + 1][s.length() + 1];
            for (int i = s.length(); i >= 1; i--) {
                for (int j = i; j <= s.length(); j++) {
                    if (j - i >= 2) {
                        pali[i][j] = pali[i + 1][j - 1];
                    }
                    if (s.charAt(i - 1) != s.charAt(j - 1)) {
                        // 修改1次
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
                            // [0,x-1] [x,j-1]
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][x] + pali[x + 1][j]);
                        }
                    }
                }
            }
            return dp[k][s.length()];
        }
    }
}
