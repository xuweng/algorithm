package com.leetcode.tag.must4.six;

import java.util.Arrays;

/**
 * 410. 分割数组的最大值
 */
public class SplitArray {
    class Solution {
        public int splitArray(int[] nums, int m) {
            int[] sum = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }
            int[][] dp = new int[nums.length + 1][m + 1];
            for (int[] ints : dp) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            dp[0][0] = 0;

            for (int i = 1; i <= nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    for (int k = 1; k <= m; k++) {
                        // [0,j-1] [j,i-1]
                        dp[i][k] = Math.min(dp[i][k], Math.max(dp[j][k - 1], sum[i] - sum[j]));
                    }
                }
            }

            return dp[nums.length][m];
        }
    }

    class Solution1 {
        public int splitArray(int[] nums, int m) {
            int left = Arrays.stream(nums).max().getAsInt();
            int right = Arrays.stream(nums).sum();

            while (left < right) {
                int mid = left + (right - left) / 2;
                int count = 1;
                int sum = 0;
                for (int num : nums) {
                    sum += num;
                    if (sum > mid) {
                        count++;
                        sum = num;
                    }
                }
                if (count <= m) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }
}
