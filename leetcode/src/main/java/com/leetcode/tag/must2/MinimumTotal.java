package com.leetcode.tag.must2;

import java.util.List;

/**
 * 120. 三角形最小路径和
 */
public class MinimumTotal {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m = triangle.size();
            int[] dp = new int[m + 1];
            for (int i = m; i >= 1; i--) {
                for (int j = 0; j < i; j++) {
                    dp[i] = Math.min(dp[i], dp[j + 1]) + triangle.get(i - 1).get(j);
                }
            }

            return dp[1];
        }
    }
}
