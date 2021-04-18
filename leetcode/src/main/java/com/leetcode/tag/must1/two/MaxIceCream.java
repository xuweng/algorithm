package com.leetcode.tag.must1.two;

import java.util.Arrays;

/**
 * 5735. 雪糕的最大数量
 */
public class MaxIceCream {
    class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            int res = 0;
            int i = 0;
            while (i < costs.length) {
                if (coins >= costs[i]) {
                    coins -= costs[i++];
                    res++;
                } else {
                    break;
                }

            }
            return res;
        }
    }

    class Solution1 {
        public int maxIceCream(int[] costs, int coins) {
            if (costs == null) {
                return 0;
            }
            Arrays.sort(costs);
            int result = 0;
            for (int i = 0; i < costs.length && coins >= costs[i]; i++) {
                result++;
                coins -= costs[i];
            }

            return result;
        }
    }
}
