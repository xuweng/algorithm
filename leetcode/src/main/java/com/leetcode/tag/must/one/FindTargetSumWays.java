package com.leetcode.tag.must.one;

/**
 * 494. 目标和
 * <p>
 * 状态压缩 二进制
 * <p>
 * 状态压缩 二进制
 */
public class FindTargetSumWays {
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[][] dp = new int[nums.length + 1][S + 1];
            for (int i = 0; i <= nums.length; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= S; j++) {
                    int s = 0;
                    if (j >= nums[i - 1]) {
                        s += dp[i - 1][j - nums[i - 1]];
                    } else if (j + nums[i - 1] <= S) {
                        s += dp[i - 1][j + nums[i - 1]];
                    } else {
                        s = dp[i - 1][j];
                    }
                    dp[i][j] = s;
                }
            }

            return dp[nums.length][S];
        }
    }

    /**
     * 方法一：枚举
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int count = 0;

        public int findTargetSumWays(int[] nums, int S) {
            calculate(nums, 0, 0, S);

            return count;
        }

        public void calculate(int[] nums, int index, int sum, int S) {
            if (index == nums.length) {
                if (sum == S) {
                    count++;
                }

                return;
            }
            calculate(nums, index + 1, sum + nums[index], S);
            calculate(nums, index + 1, sum - nums[index], S);
        }
    }
}
