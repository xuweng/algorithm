package com.leetcode.tag.must4.four;

/**
 * 1664. 生成平衡数组的方案数
 */
public class WaysToMakeFair {
    class Solution {
        public int waysToMakeFair(int[] nums) {
            // 偶-奇
            int[] dp = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                dp[i] = dp[i - 1] + ((i % 2 == 0) ? nums[i - 1] : -nums[i - 1]);
            }
            int count = 0;
            for (int i = 1; i <= nums.length; i++) {
                // 删除第i个数 i后面的奇偶反转
                // 偶数-奇数=奇数-偶数
                // 偶数+偶数=奇数+奇数
                if (dp[i - 1] == dp[nums.length] - dp[i]) {
                    count++;
                }
            }

            return count;
        }
    }
}
