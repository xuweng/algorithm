package com.leetcode.tag.dp.three;

/**
 * 53. 最大子序和
 * <p>
 * 脑里按照示例跑一遍代码
 * <p>
 * 自己写一遍 自己写一笔 自己写一遍 自己写一遍 自己写一遍 自己写一遍
 * <p>
 * 记住常见dp状态定义 记住常见dp状态定义 记住常见dp状态定义
 */
public class MaxSubArray {
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = nums[i];
                if (dp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + nums[i];
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    /**
     * 记住常见题型 记住常见dp状态定义
     * <p>
     * 简洁代码 简洁代码 简洁代码
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
    }

}
