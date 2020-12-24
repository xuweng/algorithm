package com.leetcode.tag.dp.three;

/**
 * 978. 最长湍流子数组
 * <p>
 * 一题多刷 一题多刷 一题多刷 一题多刷 一题多刷 一题多刷
 */
public class MaxTurbulenceSize {
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int[] dp = new int[arr.length];
            int[] dp1 = new int[arr.length];
            dp[0] = 1;
            dp1[0] = 1;
            int max = 1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) {
                    dp[i] = dp1[i - 1] + 1;
                    dp1[i] = 1;
                } else if (arr[i] < arr[i - 1]) {
                    dp1[i] = dp[i - 1] + 1;
                    dp[i] = 1;
                }
                max = Math.max(max, Math.max(dp[i], dp1[i]));
            }
            return max;
        }
    }
}
