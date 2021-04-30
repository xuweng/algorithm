package com.leetcode.tag.must2.four;

import java.util.Arrays;

/**
 * 1011. 在 D 天内送达包裹的能力
 * <p>
 * 可变参数 可变参数 可变参数
 */
public class ShipWithinDays {
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int left = Arrays.stream(weights).max().getAsInt();
            int right = Arrays.stream(weights).sum();
            while (left < right) {
                int mid = left + (right - left) / 2;
                int need = 1;
                int sum = 0;
                for (int weight : weights) {
                    sum += weight;
                    if (sum > mid) {
                        need++;
                        sum = weight;
                    }
                }
                if (need <= D) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return right;
        }
    }
}
