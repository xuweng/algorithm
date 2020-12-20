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

            return back(amount, coins, 0);
        }

        /**
         * 一定要start,只需要从start开始递归
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
}
