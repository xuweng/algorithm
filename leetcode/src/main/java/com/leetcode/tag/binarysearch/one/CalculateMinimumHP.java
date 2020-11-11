package com.leetcode.tag.binarysearch.one;

import java.util.Arrays;

/**
 * 174. 地下城游戏
 */
public class CalculateMinimumHP {
    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/dungeon-game/solution/di-xia-cheng-you-xi-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 几个要素：「M×N 的网格」「每次只能向右或者向下移动一步」。让人很容易想到该题使用动态规划的方法。
         *
         * @param dungeon
         * @return
         */
        public int calculateMinimumHP(int[][] dungeon) {
            int n = dungeon.length, m = dungeon[0].length;
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <= n; ++i) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[n][m - 1] = dp[n - 1][m] = 1;
            for (int i = n - 1; i >= 0; --i) {
                for (int j = m - 1; j >= 0; --j) {
                    int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(minn - dungeon[i][j], 1);
                }
            }
            return dp[0][0];
        }
    }

}
