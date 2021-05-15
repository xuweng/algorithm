package com.leetcode.tag.must3.nine;

/**
 * 1043. 分隔数组以得到最大和
 */
public class MaxSumAfterPartitioning {
    class Solution {
        public int maxSumAfterPartitioning(int[] A, int K) {
            int n = A.length;
            // dp[i]：数组的前i个数即nums[0,1...i-1],被切了Y-刀，分割成Y个数组
            int[] dp = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                int max = 0;
                // 倒序
                // 每个数组的个数最大值不超过K
                for (int j = i - 1; j >= 0 && (i - j) <= K; j--) {
                    // MAX是 nums[j,i−1] 范围内的局部最大值
                    max = Math.max(max, A[j]);
                    // (i - j)个max
                    // dp[j] 长度为j,下一个下标就是j,[j,i-1]
                    dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
                }
            }
            return dp[n];
        }
    }

    class Solution3 {
        public int maxSumAfterPartitioning(int[] A, int K) {
            int n = A.length;
            // dp[i]：数组的前i个数即nums[0,1...i-1],被切了Y-刀，分割成Y个数组
            // 长度
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                int max = 0;
                // 倒序
                // 每个数组的个数最大值不超过K
                for (int j = i; j >= 0 && j >= i - K + 1; j--) {
                    // MAX是 nums[j,i−1] 范围内的局部最大值
                    max = Math.max(max, A[j]);
                    // (i - j)个max
                    // 数据越界
                    dp[i] = Math.max(dp[i], dp[j - 1] + (i - j + 1) * max);
                }
            }
            return dp[n - 1];
        }
    }

    class Solution1 {
        public int maxSumAfterPartitioning(int[] A, int K) {
            int n = A.length;
            // dp[i]：数组的前i个数即nums[0,1...i-1],被切了Y-刀，分割成Y个数组
            int[] dp = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                int max = dp[i];
                for (int j = 0; j < i && (i - j) <= K; j++) {
                    max = Math.max(max, A[j]);
                    dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
                }
            }
            return dp[n];
        }
    }

    class Solution2 {
        public int maxSumAfterPartitioning(int[] A, int K) {
            int n = A.length;
            // dp[i]：数组的前i个数即nums[0,1...i-1],被切了Y-刀，分割成Y个数组
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int max = 0;
                // 倒序
                // 每个数组的个数最大值不超过K
                for (int j = i - 1; j >= 0 && (i - j) <= K; j--) {
                    // MAX是 nums[j,i−1] 范围内的局部最大值
                    max = Math.max(max, A[j]);
                    // (i - j)个max
                    dp[i] = Math.max(dp[i], dp[j] + (i - j) * max);
                }
            }
            return dp[n];
        }
    }
}
