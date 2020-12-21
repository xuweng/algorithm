package com.leetcode.tag.dp.three;

import java.util.Arrays;

/**
 * 518. 零钱兑换 II
 */
public class Change {
    static class Solution {
        int[] meno;

        public int change(int amount, int[] coins) {
            if (coins == null) {
                return 0;
            }
            if (coins.length == 0 && amount == 0) {
                return 1;
            }
            Arrays.sort(coins);

            meno = new int[amount + 1];

            int back = back(amount, coins, 0);

            return back;
        }

        /**
         * 一定要start,只需要从start开始递归
         * <p>
         * 缓存错误
         *
         * @param amount
         * @param coins
         * @param start
         * @return
         */
        private int back(int amount, int[] coins, int start) {
            if (amount == 0) {
                return 1;
            }
            if (amount < 0) {
                return 0;
            }
            if (meno[amount] != 0) {
                return meno[amount];
            }
            int result = 0;
            for (int i = start; i < coins.length; i++) {
                if (coins[i] > amount) {
                    // 注意不是return
                    break;
                }
                // 注意递归的start是i
                result += back(amount - coins[i], coins, i);
            }
            meno[amount] = result;
            return meno[amount];
        }
    }

    /**
     * 缓存错误答案
     * <p>
     * 继续递归计算
     */
    class Solution1 {
        public int change(int amount, int[] coins) {
            if (coins == null) {
                return 0;
            }
            if (coins.length == 0 && amount == 0) {
                return 1;
            }
            Arrays.sort(coins);

            int back = back(amount, coins, 0);

            return back;
        }

        /**
         * 一定要start,只需要从start开始递归
         * <p>
         * 500
         * [3,5,7,8,9,10,11]
         * <p>
         * amount越大，递归树越高
         * <p>
         * 缓存错误
         *
         * @param amount
         * @param coins
         * @param start  从start开始选择
         * @return
         */
        private int back(int amount, int[] coins, int start) {
            if (amount == 0) {
                return 1;
            }
            if (amount < 0) {
                return 0;
            }
            int result = 0;
            for (int i = start; i < coins.length; i++) {
                if (coins[i] > amount) {
                    // 注意不是return
                    break;
                }
                // 注意递归的start是i
                result += back(amount - coins[i], coins, i);
            }
            return result;
        }
    }

    /**
     * 方法：动态规划
     * <p>
     * 十分钟看答案 十分钟看答案 十分钟看答案 十分钟 十分钟 十分钟
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-ii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int x = coin; x < amount + 1; ++x) {
                    dp[x] += dp[x - coin];
                }
            }
            return dp[amount];
        }
    }

}
