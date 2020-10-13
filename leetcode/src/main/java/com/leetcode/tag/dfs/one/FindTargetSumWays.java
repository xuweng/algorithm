package com.leetcode.tag.dfs.one;

/**
 * 494. 目标和
 */
public class FindTargetSumWays {
    class Solution {
        int result;

        public int findTargetSumWays(int[] nums, int S) {
            dfs(nums, S, 0, 0);

            return result;
        }

        private void dfs(int[] nums, int s, int sum, int start) {
            if (start >= nums.length) {
                if (s == sum) {
                    result++;
                }
                return;
            }

            dfs(nums, s, sum + nums[start], start + 1);
            dfs(nums, s, sum - nums[start], start + 1);
        }
    }
}
