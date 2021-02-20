package com.leetcode.tag.dp.one.three;

/**
 * 877. 石子游戏
 */
public class StoneGame {
    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/stone-game/solution/shi-zi-you-xi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean stoneGame(int[] piles) {
            int length = piles.length;
            //dp[i][j] 表示当剩下的石子堆为下标 i 到下标 j 时，当前玩家与另一个玩家的石子数量之差的最大值
            int[][] dp = new int[length][length];
            //只有当 i≤j 时
            //当 i=j 时
            for (int i = 0; i < length; i++) {
                dp[i][i] = piles[i];
            }
            //当 i<j 时
            for (int i = length - 2; i >= 0; i--) {
                for (int j = i + 1; j < length; j++) {
                    //当前玩家与另一个玩家的石子数量之差的最大值
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                }
            }
            return dp[0][length - 1] > 0;
        }
    }

    /**
     * 滚动数组
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/stone-game/solution/shi-zi-you-xi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean stoneGame(int[] piles) {
            int length = piles.length;
            int[] dp = new int[length];
            for (int i = 0; i < length; i++) {
                dp[i] = piles[i];
            }
            for (int i = length - 2; i >= 0; i--) {
                for (int j = i + 1; j < length; j++) {
                    //dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                    dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
                }
            }
            return dp[length - 1] > 0;
        }
    }

}
