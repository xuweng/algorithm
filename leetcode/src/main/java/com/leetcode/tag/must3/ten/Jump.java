package com.leetcode.tag.must3.ten;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 */
public class Jump {
    class Solution {
        public int jump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            Arrays.fill(dp, Integer.MAX_VALUE - 1);
            dp[0] = 0;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= i - j) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

            return dp[nums.length - 1];
        }
    }

    class Solution1 {
        public int jump(int[] nums) {
            if (nums == null) {
                return 0;
            }
            int max = 0;
            int result = 0;
            int end = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                max = Math.max(max, i + nums[i]);
                if (i == end) {
                    // 边界
                    result++;
                    end = max;
                }
            }

            return result;
        }
    }
}
