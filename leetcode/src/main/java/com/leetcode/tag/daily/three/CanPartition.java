package com.leetcode.tag.daily.three;

/**
 * 416. 分割等和子集
 * <p>
 * 本题是经典的NP 完全问题
 */
public class CanPartition {
    class Solution {
        public boolean canPartition(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int[] preSum = new int[nums.length];
            preSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
            return true;
        }
    }

    /**
     * 方法一：动态规划
     * <p>
     * 转换为 「0 - 1」 背包问题
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/fen-ge-deng-he-zi-ji-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return false;
            }
            int sum = 0, maxNum = 0;
            for (int num : nums) {
                sum += num;
                maxNum = Math.max(maxNum, num);
            }
            if (sum % 2 != 0) {
                return false;
            }
            int target = sum / 2;
            if (maxNum > target) {
                return false;
            }
            boolean[][] dp = new boolean[n][target + 1];
            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }
            dp[0][nums[0]] = true;
            for (int i = 1; i < n; i++) {
                int num = nums[i];
                for (int j = 1; j <= target; j++) {
                    if (j >= num) {
                        dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n - 1][target];
        }
    }

}
