package com.leetcode.tag.must3.seven;

import java.util.Arrays;

/**
 * 740. 删除并获得点数
 */
public class DeleteAndEarn {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int max = Arrays.stream(nums).max().getAsInt();
            int[] count = new int[max + 1];
            // 计数
            for (int num : nums) {
                count[num]++;
            }
            int[] dp = new int[max + 1];
            dp[1] = count[1];

            for (int i = 2; i <= max; i++) {
                // 相邻不能同时选择
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i] * count[i]);
            }

            return dp[max];
        }
    }
}
