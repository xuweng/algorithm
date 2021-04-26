package com.leetcode.tag.must1.nine;

import java.util.Arrays;
import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class MinimumTotal {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m = triangle.size();
            int[][] dp = new int[m][m];
            dp[0][0] = triangle.get(0).get(0);

            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> list = triangle.get(i);
                for (int j = 0; j < list.size(); j++) {
                    if (j > 0 && j < list.size() - 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + list.get(j);
                    } else if (j > 0) {
                        dp[i][j] = dp[i - 1][j - 1] + list.get(j);
                    } else if (j < list.size() - 1) {
                        dp[i][j] = dp[i - 1][j] + list.get(j);
                    }
                }
            }

            return Arrays.stream(dp[m - 1]).min().getAsInt();
        }
    }

    class Solution1 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m = triangle.size();
            int[] dp = new int[m];
            // 没有初始化0行 初始化最大值
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = triangle.get(0).get(0);

            for (int i = 1; i < triangle.size(); i++) {
                List<Integer> list = triangle.get(i);
                for (int j = 0; j < list.size(); j++) {
                    if (j > 0 && j < list.size() - 1) {
                        dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);
                    } else if (j > 0) {
                        dp[j] = dp[j - 1] + list.get(j);
                    } else if (j < list.size() - 1) {
                        dp[j] = dp[j] + list.get(j);
                    }
                }
            }

            return Arrays.stream(dp).min().getAsInt();
        }
    }
}
