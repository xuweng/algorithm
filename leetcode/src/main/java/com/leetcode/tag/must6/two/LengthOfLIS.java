package com.leetcode.tag.must6.two;

/**
 * 300. 最长递增子序列
 */
public class LengthOfLIS {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            int max = 1;
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }

    class Solution1 {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] di = new int[nums.length];
            int index = 0;
            di[index] = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (di[index] < nums[i]) {
                    // 递增
                    di[++index] = nums[i];
                } else {
                    // 二分 替换 第一个 >
                    int left = 0;
                    int right = index;
                    while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (di[mid] < nums[i]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                    // 替换
                    di[left] = nums[i];
                }
            }

            // 长度
            return index + 1;
        }
    }
}
