package com.leetcode.tag.must5.one;

/**
 * 5762. 恰有 K 根木棍可以看到的排列数目
 */
public class RearrangeSticks {
    class Solution {
        int mod = (int) (1e9 + 7);

        public int rearrangeSticks(int n, int k) {
            long[][] dp = new long[n + 1][k + 1];
            dp[0][0] = 1;
            // 长度 个数
            // 考虑最后一根木棍是否可以被看到
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    // 如果可以被看到，那么最后一根木棍的长度一定为 i
                    // 最后一个可以看到，前i-1只需要看j-1个
                    // 前 i-1 根木棍的长度恰好为 1,2,⋯i−1 的一个排列，并且可以看到其中的 j−1 根木棍
                    dp[i][j] = dp[i - 1][j - 1];
                    // 如果不可以被看到，那么最后一根木棍的长度为 [1,i−1] 中的某个值 i-1种可能 不能是i
                    // 最后一个不能看到，前i-1就要看完，就要看j个
                    // 最后一个比i小,长度为 [1,i−1] 中的某个值，所以看不到最后一个
                    // 假设这个值为 x，那么前 i−1 根木棍的长度为 1,⋯,x−1,x+1,⋯,i 的一个排列，并且可以看到其中的 j 根木棍
                    dp[i][j] += dp[i - 1][j] * (i - 1);
                    dp[i][j] %= mod;
                }
            }

            return (int) dp[n][k];
        }
    }
}
