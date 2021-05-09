package com.leetcode.tag.must3.three;

/**
 * 1482. 制作 m 束花所需的最少天数
 */
public class MinDays {
    /**
     * 方法一：二分查找
     */
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            // 每束花需要 k 朵花，需要制作 m 束花，因此一共需要 k×m 朵花
            if (k * m > bloomDay.length) {
                // 花园中的花朵数量少于nk×m，即数组 bloomDay 的长度小于 k×m，则无法制作出指定数量的花束
                return -1;
            }
            int low = 1, high = 1;
            for (int j : bloomDay) {
                high = Math.max(high, j);
            }
            while (low < high) {
                int days = (high - low) / 2 + low;
                if (canMake(bloomDay, days, m, k)) {
                    high = days;
                } else {
                    low = days + 1;
                }
            }
            return low;
        }

        public boolean canMake(int[] bloomDay, int days, int m, int k) {
            int bouquets = 0;
            int flowers = 0;
            int length = bloomDay.length;
            for (int i = 0; i < length && bouquets < m; i++) {
                if (bloomDay[i] <= days) {
                    flowers++;
                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }
            return bouquets >= m;
        }
    }
}
