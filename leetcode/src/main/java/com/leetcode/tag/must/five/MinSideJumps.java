package com.leetcode.tag.must.five;

import java.util.Arrays;

/**
 * 5728. 最少侧跳次数
 */
public class MinSideJumps {
    /**
     * 方法：动态规划
     * <p>
     * 定义一维数组 dp[3]：
     * dp[j] 表示当前位置 j 表示停留在第 j 个道的最小次数。
     * <p>
     * 定义状态转移方程：（详细逻辑见代码注释）
     * <p>
     * 初始化：先把当前位置填充上都有障碍物的情况，用 Integer.MAX_VALUE - 10000 防止溢出
     * 如果实际上 j 位置无障碍物，先更新为前一位置的次数
     * 尝试，从非 j 的位置跳过来，是否次数更小
     * <p>
     * 作者：hu-li-hu-wai
     * 链接：https://leetcode-cn.com/problems/minimum-sideway-jumps/solution/dp-dong-tai-gui-hua-by-hu-li-hu-wai-dah5/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int minSideJumps(int[] obstacles) {
            int n = obstacles.length;
            //dp[j] 表示当前位置 j 表示停留在第 j 个道的最小次数。
            int[] dp = new int[3];
            dp[0] = dp[2] = 1;
            for (int i = 1; i < n; i++) {
                int obs = obstacles[i];
                //初始化dp，分两步
                int pre0 = dp[0];
                int pre1 = dp[1];
                int pre2 = dp[2];
                //1.最大值填充
                Arrays.fill(dp, Integer.MAX_VALUE - 10000);
                //2.实际障碍物情况：如果 j 位置无障碍物，先更新为刚刚保存的前一位置pre的次数
                if (obs != 1) {
                    dp[0] = pre0;
                }
                if (obs != 2) {
                    dp[1] = pre1;
                }
                if (obs != 3) {
                    dp[2] = pre2;
                }
                //比较从非 j 的位置跳过来，是否次数更小
                if (obs != 1) {
                    dp[0] = Math.min(dp[0], Math.min(dp[1], dp[2]) + 1);
                }
                if (obs != 2) {
                    dp[1] = Math.min(dp[1], Math.min(dp[0], dp[2]) + 1);
                }
                if (obs != 3) {
                    dp[2] = Math.min(dp[2], Math.min(dp[0], dp[1]) + 1);
                }
            }
            return Arrays.stream(dp).min().orElse(-1);
        }
    }

    /**
     * 任何一个点的三条跑道中 最多有一个 障碍
     * <p>
     * 点 0 处和点 n 处的任一跑道都不会有障碍
     * <p>
     * 一共3条跑道，n个点，
     * 1.如果跑道i当前位置k(0<=k<n)有石头，无论如何跳也到不了该处，dp[k][i]=Integer.MAX_VALUE-1（避免加1后超出int范围）；
     * 2.如果当前位置没有石头，则跳到该点的方法为:
     * <p>
     * 同一跑道前一节点跳过来，dp[k][i]=dp[k-1][i],
     * 其他两条跑道中没有石头的节点j跳过来，前一节点次数加1(侧跳一次),dp[k-1][j]+1.
     * 取最小值dp[k]][i]=Math.min(dp[k-1][i],dp[k-1][j]+1)。
     * <p>
     * 作者：gao-he-jin
     * 链接：https://leetcode-cn.com/problems/minimum-sideway-jumps/solution/javadong-tai-gui-hua-by-gao-he-jin-guw6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int minSideJumps(int[] obstacles) {
            //obstacles[i] （取值范围从 0 到 3）表示在点 i 处的 obstacles[i] 跑道上有一个障碍
            int n = obstacles.length;
            // 3个跑道 0 1 2
            int[][] dp = new int[n][3];
            // 这只青蛙从点 0 处跑道 2 出发
            // 2跑道到1跑道跳1次
            dp[0][0] = 1;
            // 2跑道到3跑道跳1次
            dp[0][2] = 1;

            for (int i = 1; i < n; ++i) {
                if (obstacles[i] == 1) {
                    // i处1跑道有障碍
                    dp[i][0] = Integer.MAX_VALUE - 1;
                    dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][2] + 1);
                    dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][1] + 1);
                } else if (obstacles[i] == 2) {
                    // i处2跑道有障碍
                    dp[i][1] = Integer.MAX_VALUE - 1;
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][2] + 1);
                    dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][0] + 1);
                } else if (obstacles[i] == 3) {
                    // i处3跑道有障碍
                    dp[i][2] = Integer.MAX_VALUE - 1;
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1] + 1);
                    dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0] + 1);
                } else {
                    // i处没有障碍
                    dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2]) + 1);
                    dp[i][1] = Math.min(dp[i - 1][1], Math.min(dp[i - 1][0], dp[i - 1][2]) + 1);
                    dp[i][2] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][0], dp[i - 1][1]) + 1);
                }
            }

            //这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数
            return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        }
    }

    class Solution2 {
        public int minSideJumps(int[] obstacles) {
            //obstacles[i] （取值范围从 0 到 3）表示在点 i 处的 obstacles[i] 跑道上有一个障碍
            int n = obstacles.length;
            // 3个跑道 1 2 3
            int[][] dp = new int[n][4];
            // 这只青蛙从点 0 处跑道 2 出发
            // 2跑道到1跑道跳1次
            dp[0][1] = 1;
            // 2跑道到3跑道跳1次
            dp[0][3] = 1;

            for (int i = 1; i < n; ++i) {
                if (obstacles[i] == 1) {
                    // i处1跑道有障碍
                    dp[i][1] = Integer.MAX_VALUE - 1;
                    dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][3] + 1);
                    dp[i][3] = Math.min(dp[i - 1][3], dp[i - 1][2] + 1);
                } else if (obstacles[i] == 2) {
                    // i处2跑道有障碍
                    dp[i][2] = Integer.MAX_VALUE - 1;
                    dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][3] + 1);
                    dp[i][3] = Math.min(dp[i - 1][3], dp[i - 1][1] + 1);
                } else if (obstacles[i] == 3) {
                    // i处3跑道有障碍
                    dp[i][3] = Integer.MAX_VALUE - 1;
                    dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][2] + 1);
                    dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][1] + 1);
                } else {
                    // i处没有障碍
                    dp[i][1] = Math.min(dp[i - 1][1], Math.min(dp[i - 1][2], dp[i - 1][3]) + 1);
                    dp[i][2] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][1], dp[i - 1][3]) + 1);
                    dp[i][3] = Math.min(dp[i - 1][3], Math.min(dp[i - 1][1], dp[i - 1][2]) + 1);
                }
            }

            //这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数
            return Math.min(dp[n - 1][1], Math.min(dp[n - 1][2], dp[n - 1][3]));
        }
    }
}
