package com.leetcode.tag.daily.two;

/**
 * 486. 预测赢家
 * <p>
 * 不做太晦涩的题。
 * <p>
 * 直接看题解直接看代码。
 */
public class PredictTheWinner {
    class Solution {
        public boolean PredictTheWinner(int[] nums) {
            return true;
        }
    }

    /**
     * 方法一：递归
     * <p>
     * 2个分支。2个选择策略。
     * <p>
     * 选择第一个；选择第二个。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/predict-the-winner/solution/yu-ce-ying-jia-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean PredictTheWinner(int[] nums) {
            return total(nums, 0, nums.length - 1, 1) >= 0;
        }

        public int total(int[] nums, int start, int end, int turn) {
            if (start == end) {
                return nums[start] * turn;
            }
            int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
            int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
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
    class Solution2 {
        public boolean PredictTheWinner(int[] nums) {
            int length = nums.length;
            int[][] dp = new int[length][length];
            for (int i = 0; i < length; i++) {
                dp[i][i] = nums[i];
            }
            for (int i = length - 2; i >= 0; i--) {
                for (int j = i + 1; j < length; j++) {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
            return dp[0][length - 1] >= 0;
        }
    }


}
