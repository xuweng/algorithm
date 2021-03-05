package com.leetcode.tag.backtracking.two;

import java.util.Arrays;

/**
 * 698. 划分为k个相等的子集
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
            sum = sum / k;

            boolean[] used = new boolean[nums.length];

            return back(k, 0, nums, 0, sum, used);
        }

        private boolean back(int k, int s, int[] nums, int start, int target, boolean[] used) {
            if (k == 0) {
                return true;
            }
            if (s == target) {
                return back(k - 1, 0, nums, 0, target, used);
            }
            for (int i = start; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (s + nums[i] > target) {
                    continue;
                }
                used[i] = true;
                if (back(k, s + nums[i], nums, i + 1, target, used)) {
                    return true;
                }
                used[i] = false;
            }

            return false;
        }
    }
}
