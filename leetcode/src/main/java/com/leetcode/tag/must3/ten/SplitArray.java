package com.leetcode.tag.must3.ten;

import java.util.Arrays;

/**
 * 410. 分割数组的最大值
 */
public class SplitArray {
    class Solution {
        public int splitArray(int[] nums, int m) {
            int n = nums.length;
            // 令 f[i][j]表示将数组的前 i 个数分割为 j 段所能得到的最大连续子数组和的最小值
            int[][] f = new int[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(f[i], Integer.MAX_VALUE);
            }
            f[0][0] = 0;
            int[] sub = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sub[i + 1] = sub[i] + nums[i];
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    for (int k = 1; k <= Math.min(i, m); j++) {
                        f[i][k] = Math.min(f[i][k], Math.max(f[j][k - 1], sub[i] - sub[j]));
                    }
                }
            }
            return f[n][m];
        }
    }
}
