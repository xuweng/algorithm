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
}
