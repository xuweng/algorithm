package com.leetcode.tag.must.one;

/**
 * 45. 跳跃游戏 II
 * <p>
 * dp:枚举所有子问题
 * <p>
 * 贪心:局部最优,选择最优子问题
 */
public class Jump {
    class Solution {
        public int jump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (dp[j] != Integer.MAX_VALUE && nums[j] >= i - j) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }

            return dp[nums.length - 1];
        }
    }

    /**
     * 贪心算法
     * <p>
     * 方法一：反向查找出发位置
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 如果有多个位置通过跳跃都能够到达最后一个位置，那么我们应该如何进行选择呢？直观上来看，
         * <p>
         * 我们可以「贪心」地选择距离最后一个位置最远的那个位置，也就是对应下标最小的那个位置
         * <p>
         * 作者：LeetCode-Solution
         * 链接：https://leetcode-cn.com/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param nums
         * @return
         */
        public int jump(int[] nums) {
            int position = nums.length - 1;
            int steps = 0;
            while (position > 0) {
                for (int i = 0; i < position; i++) {
                    if (i + nums[i] >= position) {
                        position = i;
                        steps++;
                        break;
                    }
                }
            }
            return steps;
        }
    }

}
