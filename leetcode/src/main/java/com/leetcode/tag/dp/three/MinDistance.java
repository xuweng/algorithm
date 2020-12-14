package com.leetcode.tag.dp.three;

/**
 * 72. 编辑距离
 * <p>
 * 初始化 计算顺序
 */
public class MinDistance {
    class Solution {
        /**
         * 分类讨论 分类讨论 分类讨论 分类讨论 分类讨论 分类讨论 分类讨论
         * <p>
         * 排序 排序 排序 排序 排序 排序 排序 排序 排序 排序 排序
         *
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance(String word1, String word2) {
            if (word1 == null || word2 == null) {
                return 0;
            }
            // 状态定义 状态定义 状态定义
            int[][] dp = new int[word1.length() + 1][word2.length() + 1];

            // 初始化0行
            for (int i = 1; i <= word2.length(); i++) {
                dp[0][i] = i;
            }
            // 初始化0列
            for (int i = 1; i <= word1.length(); i++) {
                dp[i][0] = i;
            }

            // 从1行1列开始dp
            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }
    }
}
