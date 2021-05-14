package com.leetcode.tag.must3.seven;

/**
 * 55. 跳跃游戏
 */
public class CanJump {
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= i - j) {
                        dp[i] = dp[i] || dp[j];
                    }
                }
            }

            return dp[nums.length - 1];
        }
    }

    class Solution1 {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            boolean[] dp = new boolean[nums.length];
            dp[0] = true;

            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && nums[j] >= i - j) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[nums.length - 1];
        }
    }

    /**
     * 贪心
     */
    class Solution2 {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            // 跳跃的最大长度为 x+nums[x]
            // 维护 最远可以到达的位置
            int rightmost = 0;
            for (int i = 0; i < n && i <= rightmost; ++i) {
                // x+nums[x] 更新 最远可以到达的位置
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    // 最后一个位置可达
                    return true;
                }
            }
            return false;
        }
    }
}
