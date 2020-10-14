package com.leetcode.tag.dfs.one;

/**
 * 494. 目标和
 * <p>
 * 递增递归
 * <p>
 * 处理候选集
 */
public class FindTargetSumWays {
    class Solution {
        int result;

        public int findTargetSumWays(int[] nums, int S) {
            dfs(nums, S, 0, 0);

            return result;
        }

        private void dfs(int[] nums, int s, int sum, int start) {
            if (start >= nums.length) {
                //越界统计
                if (s == sum) {
                    result++;
                }
                return;
            }

            dfs(nums, s, sum + nums[start], start + 1);
            dfs(nums, s, sum - nums[start], start + 1);
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

        public void calculate(int[] nums, int i, int sum, int S) {
            if (i == nums.length) {
                if (sum == S) {
                    count++;
                }
            } else {
                calculate(nums, i + 1, sum + nums[i], S);
                calculate(nums, i + 1, sum - nums[i], S);
            }
        }
    }

    /**
     * 方法二：动态规划
     * <p>
     * 画表格理解dp状态转换
     * <p>
     * 计算顺序
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        /**
         * 用 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数
         * <p>
         * i-1---->i?
         * <p>
         * i-1如何到i?
         * <p>
         * dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
         *
         * @param nums
         * @param S
         * @return
         */
        public int findTargetSumWays(int[] nums, int S) {
            int[][] dp = new int[nums.length][2001];
            dp[0][nums[0] + 1000] = 1;
            dp[0][-nums[0] + 1000] += 1;
            for (int i = 1; i < nums.length; i++) {
                for (int sum = -1000; sum <= 1000; sum++) {
                    if (dp[i - 1][sum + 1000] > 0) {
                        dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                        dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                    }
                }
            }
            return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
        }
    }

}
