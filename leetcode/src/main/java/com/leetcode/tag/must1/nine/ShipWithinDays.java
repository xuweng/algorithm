package com.leetcode.tag.must1.nine;

import java.util.Arrays;

/**
 * 1011. 在 D 天内送达包裹的能力
 */
public class ShipWithinDays {
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            // 确定二分查找左右边界
            int left = Arrays.stream(weights).max().getAsInt();
            int right = Arrays.stream(weights).sum();
            while (left < right) {
                int mid = (left + right) / 2;
                // need 为需要运送的天数
                // cur 为当前这一天已经运送的包裹重量之和
                int need = 1, cur = 0;
                for (int weight : weights) {
                    if (cur + weight > mid) {
                        ++need;
                        cur = 0;
                    }
                    cur += weight;
                }
                if (need <= D) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }
}
