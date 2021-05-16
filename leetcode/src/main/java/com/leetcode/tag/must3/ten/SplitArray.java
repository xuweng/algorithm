package com.leetcode.tag.must3.ten;

import java.util.Arrays;

/**
 * 410. 分割数组的最大值
 * <p>
 * 长度划分 前k-1 第k
 */
public class SplitArray {
    class Solution {
        public int splitArray(int[] nums, int m) {
            int n = nums.length;
            // 令 dp[i][j]表示将数组的前 i 个数分割为 j 段所能得到的最大连续子数组和的最小值
            int[][] dp = new int[n + 1][m + 1];
            for (int[] ints : dp) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            dp[0][0] = 0;
            // 前缀和
            int[] preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            // 枚举长度
            for (int i = 1; i <= n; i++) {
                // 枚举下标
                for (int j = 0; j < i; j++) {
                    // 枚举k
                    for (int k = 1; k <= Math.min(i, m); k++) {
                        // 前k-1个 第k个 最后一个
                        // 第k个 [j,i-1] 区间和 preSum[i] - preSum[j]
                        dp[i][k] = Math.min(dp[i][k], Math.max(dp[j][k - 1], preSum[i] - preSum[j]));
                    }
                }
            }
            return dp[n][m];
        }
    }
}
