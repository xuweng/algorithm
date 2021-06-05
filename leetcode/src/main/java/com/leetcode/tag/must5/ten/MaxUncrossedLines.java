package com.leetcode.tag.must5.ten;

/**
 * 1035. 不相交的线
 */
public class MaxUncrossedLines {
    class Solution {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }

            return dp[nums1.length][nums2.length];
        }
    }

    class Solution1 {
        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            int[] dp = new int[nums2.length + 1];
            for (int i = 1; i <= nums1.length; i++) {
                int pre = dp[0];
                for (int j = 1; j <= nums2.length; j++) {
                    int cur = dp[j];
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[j] = pre + 1;
                    } else {
                        dp[j] = Math.max(dp[j - 1], dp[j]);
                    }
                    pre = cur;
                }
            }

            return dp[nums2.length];
        }
    }
}
