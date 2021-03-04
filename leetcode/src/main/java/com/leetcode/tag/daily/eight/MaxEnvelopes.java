package com.leetcode.tag.daily.eight;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 */
public class MaxEnvelopes {
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, (arr1, arr2) -> {
                if (arr1[0] == arr2[0]) {
                    // 降序
                    return arr2[1] - arr1[1];
                } else {
                    // 升序
                    return arr1[0] - arr2[0];
                }
            });
            int[] secondDim = Arrays.stream(envelopes).mapToInt(envelope -> envelope[1]).toArray();

            return lis(secondDim);
        }

        private int lis(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= nums[i]) {
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
            Arrays.sort(envelopes, (arr1, arr2) -> {
                if (arr1[0] == arr2[0]) {
                    // 降序
                    return arr2[1] - arr1[1];
                } else {
                    // 升序
                    return arr1[0] - arr2[0];
                }
            });
            int[] secondDim = Arrays.stream(envelopes).mapToInt(envelope -> envelope[1]).toArray();

            return lengthOfLIS1(secondDim);
        }

        public int lengthOfLIS1(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= nums[i]) {
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
