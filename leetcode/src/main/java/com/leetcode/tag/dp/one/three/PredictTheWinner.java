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

}
