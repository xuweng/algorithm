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
     * 数据范围 数据范围 数据范围 数据范围 数据范围
     * <p>
     * 数据二分 数据二分 数据二分
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
            // 确定数据范围
            int low = 1, high = 1;
            for (int j : bloomDay) {
                high = Math.max(high, j);
            }
            while (low < high) {
                // 假设尝试 days 作为最小的天数, 看看能不能制作要求的花束
                int days = (high - low) / 2 + low;
                if (canMake(bloomDay, days, m, k)) {
                    // 如果可以制作花束, 那么可以尝试天数再减小一点, 因此right往左走, 缩小搜索范围
                    high = days;
                } else {
                    // 如果无法制作花束, 那么可以尝试天数再增大一点, 因此left往右边走, 区间的左边值加大
                    low = days + 1;
                }
            }
            return low;
        }

        public boolean canMake(int[] bloomDay, int days, int m, int k) {
            // 记录花束
            int bouquets = 0;
            // 数=连续的花朵数量
            int flowers = 0;
            int length = bloomDay.length;
            for (int i = 0; i < length && bouquets < m; i++) {
                if (bloomDay[i] <= days) {
                    // 第 i 朵花会在 bloomDay[i] 时盛开
                    // 第 i 朵花在days天内盛开 可以制作花
                    // 必须是连续的花朵, 这个可以通过变量 flower 来计数是否连续, 一旦不连续就重置为 0
                    flowers++;
                    if (flowers == k) {
                        // 花束++
                        bouquets++;
                        // 每满足一次连续的 k 朵花, 就可以制作一束花, flower 计数重新为 0 开始计数
                        flowers = 0;
                    }
                } else {
                    // 第 i 朵花在不是days天内盛开
                    //  一旦不连续就重置为 0
                    flowers = 0;
                }
            }
            // 花束>=m
            return bouquets >= m;
        }
    }
}
