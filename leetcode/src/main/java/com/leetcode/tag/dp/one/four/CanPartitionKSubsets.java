package com.leetcode.tag.dp.one.four;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
 * <p>
 * 初始化 正序 倒序
 */
public class CanPartitionKSubsets {
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int sum = Arrays.stream(nums).sum();
            if (sum % k != 0) {
                return false;
            }
            int target = sum / k;
            boolean[] used = new boolean[nums.length];

            return dfs(nums, k, 0, target, 0, used);
        }

        private boolean dfs(int[] nums, int k, int s, int target, int index, boolean[] used) {
            if (k == 0) {
                return true;
            }
            if (s == target) {
                return dfs(nums, k - 1, 0, target, 0, used);
            }
            for (int i = index; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (s + nums[i] > target) {
                    continue;
                }
                used[i] = true;
                if (dfs(nums, k, s + nums[i], target, i + 1, used)) {
                    return true;
                }
                used[i] = false;
            }

            return false;
        }
    }
}
