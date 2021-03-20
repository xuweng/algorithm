package com.leetcode.tag.dp.one.three;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 */
public class MaxEnvelopes {
    class Solution {
        /**
         * lis 一维
         * <p>
         * 二维 固定第1个维度(升序) 第二个维度lis
         */
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (arr1, arr2) -> {
                if (arr1[0] == arr2[0]) {
                    // 后降序
                    return arr2[1] - arr1[1];
                } else {
                    // 先升序
                    return arr1[0] - arr2[0];
                }
            });
            // 取高
            int[] secondDim = Arrays.stream(envelopes).mapToInt(envelope -> envelope[1]).toArray();

            return lengthOfLIS1(secondDim);
        }

        private int lengthOfLIS1(int[] secondDim) {
            int[] dp = new int[secondDim.length];
            int max = 1;
            for (int i = 0; i < secondDim.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (secondDim[j] >= secondDim[i]) {
                        continue;
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    class Solution1 {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0) {
                return 0;
            }

            Arrays.sort(envelopes, (arr1, arr2) -> {
                if (arr1[0] == arr2[0]) {
                    // 后降序
                    return arr2[1] - arr1[1];
                } else {
                    // 先升序
                    return arr1[0] - arr2[0];
                }
            });
            // 取高
            int[] secondDim = Arrays.stream(envelopes).mapToInt(envelope -> envelope[1]).toArray();

            return lengthOfLIS1(secondDim);
        }

        private int lengthOfLIS1(int[] secondDim) {
            int[] dp = new int[secondDim.length];
            int max = 1;
            for (int i = 0; i < secondDim.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (secondDim[j] >= secondDim[i]) {
                        continue;
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }
}
