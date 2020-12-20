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

            return back(amount, coins);
        }

        private int back(int amount, int[] coins) {
            if (amount <= 0) {
                return 0;
            }
            int result = 0;
            for (int coin : coins) {
                if (coin > amount) {
                    return 0;
                }
                result += back(amount - coin, coins) + 1;
            }
            return result;
        }
    }
}
