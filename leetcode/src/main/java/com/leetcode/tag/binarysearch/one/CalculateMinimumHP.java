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
         * <p>
         * 对于每一条路径，我们需要同时记录两个值。第一个是「从出发点到当前点的路径和」，第二个是「从出发点到当前点所需的最小初始值」
         * <p>
         * 希望「从出发点到当前点的路径和」尽可能大，而「从出发点到当前点所需的最小初始值」尽可能小
         * <p>
         * 按照从左上往右下的顺序进行动态规划，我们无法直接确定到达 的方案，因为有两个重要程度相同的参数同时影响后续的决策。
         * <p>
         * 也就是说，这样的动态规划是不满足「无后效性」的。
         * <p>
         * 考虑从右下往左上进行动态规划.
         * <p>
         * 令 dp[i][j] 表示从坐标 (i,j) 到终点所需的最小初始值。换句话说，当我们到达坐标 (i,j) 时，如果此时我们的路径和不小于 dp[i][j]，我们就能到达终点
         * <p>
         * 这样一来，我们就无需担心路径和的问题，只需要关注最小初始值
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

    /**
     * 作者：fakerleet
     * 链接：https://leetcode-cn.com/problems/dungeon-game/solution/cong-hui-su-dao-ji-yi-hua-sou-suo-dao-dong-tai-gui/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
                return 0;
            }
            int rowLen = dungeon.length;
            int colLen = dungeon[0].length;
            // 最低的耗血量为 + 1；就是骑士的救公主的最低血量。
            return dfs(0, 0, rowLen, colLen, dungeon) + 1;
        }

        public int dfs(int rowIndex, int colIndex, int rowSize, int colSize, int[][] dungeon) {
            if (rowIndex >= rowSize || colIndex >= colSize) {
                return Integer.MAX_VALUE;
            }
            // 退出条件
            if (rowIndex == rowSize - 1 && colIndex == colSize - 1) {
                // 最后一格
                // 如果最后一个大于等于0，就返还0。
                //如果最后一个小于零，就返回负的值。
                return dungeon[rowIndex][colIndex] >= 0 ? 0 : -dungeon[rowIndex][colIndex];
            }
            //  右边格子的最优解，也就是最低的耗血量
            int rightMin = dfs(rowIndex, colIndex + 1, rowSize, colSize, dungeon);
            //  下边格子的最优解
            int downMin = dfs(rowIndex + 1, colIndex, rowSize, colSize, dungeon);
            // f(i,j) = min(f(i+1, j), f(i, j+1)) - dungeon[i][j]
            int needMin = Math.min(rightMin, downMin) - dungeon[rowIndex][colIndex];
            return Math.max(needMin, 0);
        }

    }

}
