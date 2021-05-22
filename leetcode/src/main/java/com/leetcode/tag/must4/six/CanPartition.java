package com.leetcode.tag.must4.six;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * <p>
 * i j 模型
 * <p>
 * i j 模型
 * <p>
 * 覆盖前记录 覆盖前记录
 */
public class CanPartition {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 != 0) {
                return false;
            }
            int s = sum / 2;

            boolean[] dp = new boolean[s + 1];
            dp[0] = true;

            for (int num : nums) {
                for (int i = s; i >= num; i--) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }

            return dp[s];
        }
    }
}
