package com.leetcode.tag.must6.one;

/**
 * 474. 一和零
 * <p>
 * 滑动窗口
 * <p>
 * 前缀和
 * <p>
 * 二分
 */
public class FindMaxForm1 {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            for (String str : strs) {
                int[] count = count(str);
                for (int i = m; i >= count[0]; i--) {
                    for (int j = n; j >= count[1]; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                    }
                }
            }

            return dp[m][n];
        }

        private int[] count(String s) {
            int[] result = new int[2];
            for (int i = 0; i < s.length(); i++) {
                result[s.charAt(i) - '0']++;
            }

            return result;
        }
    }
}
