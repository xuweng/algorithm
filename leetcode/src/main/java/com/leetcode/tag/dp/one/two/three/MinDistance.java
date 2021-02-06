package com.leetcode.tag.dp.one.two.three;

/**
 * 72. 编辑距离
 * <p>
 * 初始化 计算顺序 分类讨论
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

    /**
     * 看图 看图 看图 看图 看图 看图 看图 看图 看图 看图 看图
     * <p>
     * 具体方案 从终点开始回溯 有多条路径 回溯 多条路径 多条路径 多条路径 多条路径 多条路径
     */
    class Solution1 {
        // int[][] dp;
        // 这里只求出了最小的编辑距离，那具体的操作是什么？
        // 给 dp 数组增加额外的信息即可：
        Node[][] dp;

        class Node {
            int val;
            int choice;
            // 0 代表啥都不做
            // 1 代表插入
            // 2 代表删除
            // 3 代表替换
        }

        /**
         * 每个 dp[i][j] 只和它附近的三个状态有关
         * <p>
         * 这里只求出了最小的编辑距离，那具体的操作是什么？
         *
         * @param s1
         * @param s2
         * @return
         */
        int minDistance(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            // base case
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }
            // 自底向上求解
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = min(
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1,
                                dp[i - 1][j - 1] + 1
                        );
                    }
                }
            }
            // 储存着整个 s1 和 s2 的最小编辑距离
            return dp[m][n];
        }

        int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
    }
}
