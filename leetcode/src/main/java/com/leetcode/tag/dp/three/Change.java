package com.leetcode.tag.dp.three;

import java.util.Arrays;

/**
 * 518. 零钱兑换 II
 */
public class Change {
    class Solution {
        public int change(int amount, int[] coins) {
            if (coins == null || coins.length == 0) {
                return 0;
            }
            Arrays.sort(coins);

            return back(amount, coins, 0);
        }

        private int back(int amount, int[] coins, int start) {
            if (amount <= 0) {
                return 0;
            }
            int result = 0;
            for (int i = start; i < coins.length; i++) {
                int coin = coins[i];
                if (coin > amount) {
                    return 0;
                }
                result += back(amount - coin, coins, start) + 1;
            }
            return result;
        }
    }
}
