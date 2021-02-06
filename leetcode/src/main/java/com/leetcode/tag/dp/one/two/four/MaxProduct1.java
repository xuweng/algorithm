package com.leetcode.tag.dp.one.two.four;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct1 {
    /**
     * 分类讨论 思路清晰
     */
    class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[][] dp = new int[nums.length][2];
            // 不合理状态初始化为0
            // 股票不合理状态初始化为I
            dp[0][0] = Math.min(nums[0], 0);
            dp[0][1] = Math.max(nums[0], 0);

            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
                    dp[i][1] = dp[i - 1][0] * nums[i];
                } else if (nums[i] >= 0) {
                    dp[i][0] = dp[i - 1][0] * nums[i];
                    dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                }

                max = Math.max(max, dp[i][1]);
            }

            return max;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray/solution/cheng-ji-zui-da-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maxProduct(int[] nums) {
            int length = nums.length;
            int[] maxF = new int[length];
            int[] minF = new int[length];
            System.arraycopy(nums, 0, maxF, 0, length);
            System.arraycopy(nums, 0, minF, 0, length);
            for (int i = 1; i < length; ++i) {
                maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
                minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            }
            int ans = maxF[0];
            for (int i = 1; i < length; ++i) {
                ans = Math.max(ans, maxF[i]);
            }
            return ans;
        }
    }

}
