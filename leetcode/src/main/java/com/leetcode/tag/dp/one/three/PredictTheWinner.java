package com.leetcode.tag.dp.one.three;

/**
 * 486. 预测赢家
 */
public class PredictTheWinner {
    /**
     * 方法一：递归
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/predict-the-winner/solution/yu-ce-ying-jia-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            return total(nums, 0, nums.length - 1, 1) >= 0;
        }

        /**
         * 计算一个总分，即先手得分与后手得分之差
         *
         * @param nums
         * @param start
         * @param end
         * @param turn
         * @return 先手得分与后手得分之差
         */
        public int total(int[] nums, int start, int end, int turn) {
            if (start == end) {
                return nums[start] * turn;
            }
            // turn 当前符合
            // -turn 下一层递归符号
            // + - + - + -....

            //先手得分与后手得分之差
            int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
            //先手得分与后手得分之差
            int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
            // 选择最大的差
            return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
        }
    }

    /**
     * 方法二：动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/predict-the-winner/solution/yu-ce-ying-jia-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean PredictTheWinner(int[] nums) {
            int length = nums.length;
            // 只能选择i或者j
            // dp[i][j] 表示当数组剩下的部分为下标 i 到下标 j 时，当前玩家与另一个玩家的分数之差的最大值，
            // 注意当前玩家不一定是先手
            int[][] dp = new int[length][length];
            // i≤j
            // 当 i=j 时
            for (int i = 0; i < length; i++) {
                //当 i=j 时，只剩一个数字，当前玩家只能拿取这个数字
                dp[i][i] = nums[i];
            }
            // 当 i<j 时
            // 遍历顺序
            for (int i = length - 2; i >= 0; i--) {
                for (int j = i + 1; j < length; j++) {
                    //当前玩家与另一个玩家的分数之差的最大值
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
            // 结果
            return dp[0][length - 1] >= 0;
        }
    }

    /**
     * 滚动数组
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/predict-the-winner/solution/yu-ce-ying-jia-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public boolean PredictTheWinner(int[] nums) {
            int length = nums.length;
            int[] dp = new int[length];
            for (int i = 0; i < length; i++) {
                dp[i] = nums[i];
            }
            for (int i = length - 2; i >= 0; i--) {
                for (int j = i + 1; j < length; j++) {
                    // dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
            return dp[length - 1] >= 0;
        }
    }

}
