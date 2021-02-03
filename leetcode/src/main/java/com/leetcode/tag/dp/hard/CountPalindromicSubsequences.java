package com.leetcode.tag.dp.hard;

/**
 * 730. 统计不同回文子序列
 * <p>
 * 数据结构 双端队列 lru 双堆
 */
public class CountPalindromicSubsequences {
    /**
     * 方法一：动态规划（使用三维数组）
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/count-different-palindromic-subsequences/solution/tong-ji-bu-tong-hui-wen-zi-zi-fu-chuan-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int countPalindromicSubsequences(String S) {
            int n = S.length();
            int mod = 1000000007;
            int[][][] dp = new int[4][n][n];

            for (int i = n - 1; i >= 0; --i) {
                for (int j = i; j < n; ++j) {
                    for (int k = 0; k < 4; ++k) {
                        char c = (char) ('a' + k);
                        if (j == i) {
                            if (S.charAt(i) == c) dp[k][i][j] = 1;
                            else dp[k][i][j] = 0;
                        } else { // j > i
                            if (S.charAt(i) != c) dp[k][i][j] = dp[k][i + 1][j];
                            else if (S.charAt(j) != c) dp[k][i][j] = dp[k][i][j - 1];
                            else { // S[i] == S[j] == c
                                if (j == i + 1) dp[k][i][j] = 2; // "aa" : {"a", "aa"}
                                else { // length is > 2
                                    dp[k][i][j] = 2;
                                    for (int m = 0; m < 4; ++m) { // count each one within subwindows [i+1][j-1]
                                        dp[k][i][j] += dp[m][i + 1][j - 1];
                                        dp[k][i][j] %= mod;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            int ans = 0;
            for (int k = 0; k < 4; ++k) {
                ans += dp[k][0][n - 1];
                ans %= mod;
            }

            return ans;
        }
    }

}
