package com.leetcode.tag.must3.three;

/**
 * 1482. 制作 m 束花所需的最少天数
 * <p>
 * 1011. 在 D 天内送达包裹的能力
 */
public class MinDays {
    /**
     * 方法一：二分查找
     * <p>
     * 制作花朵最少的时间必然是 bloomDay 数组中开花所用天数最少的那朵花 min(bloomDay)
     * 制作花朵最多的时间也只能是 bloomDay 数组中开花所需天数最多的那朵花 max(bloomDay)
     * 寻找制作花束的最少天数必然落在上面所说的区间里 [min(bloomDay),max(bloomDay)], 连续的一个正整数区间, 因此可以通过二分查找来提升查找效率!
     */
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            // 每束花需要 k 朵花，需要制作 m 束花，因此一共需要 k×m 朵花
            if (k * m > bloomDay.length) {
                // 花园中的花朵数量少于 k×m，即数组 bloomDay 的长度小于 k×m，则无法制作出指定数量的花束
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
