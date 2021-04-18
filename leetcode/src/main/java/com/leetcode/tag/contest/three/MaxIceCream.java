package com.leetcode.tag.contest.three;

import java.util.Arrays;

/**
 * 5735. 雪糕的最大数量
 */
public class MaxIceCream {
    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            if (costs == null) {
                return 0;
            }
            Arrays.sort(costs);
            int result = 0;
            for (int cost : costs) {
                if (coins >= cost) {
                    result++;
                    coins -= cost;
                }
            }

            return result;
        }
    }
}
