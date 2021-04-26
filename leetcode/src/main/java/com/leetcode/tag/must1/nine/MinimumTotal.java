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
            for (int[] ints : dp) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
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
}
