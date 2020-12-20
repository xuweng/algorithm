package com.leetcode.tag.dp.three;

/**
 * 518. 零钱兑换 II
 */
public class Change {
    class Solution {
        public int change(int amount, int[] coins) {
            if (coins == null || coins.length == 0) {
                return 0;
            }

            return back(amount, coins);
        }

        private int back(int amount, int[] coins) {
            int result = 0;
            for (int coin : coins) {
                if (coin > amount) {
                    continue;
                }
                result += back(amount - coin, coins) + 1;
            }
            return result;
        }
    }
}
