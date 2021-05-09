package com.leetcode.tag.must3.three;

import java.util.Arrays;

/**
 * 1011. 在 D 天内送达包裹的能力
 */
public class ShipWithinDays {
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int left = Arrays.stream(weights).max().getAsInt();
            int right = Arrays.stream(weights).sum();

            while (left <= right) {
                int mid = left + (right - left) / 2;
                // 天数
                int count = 1;
                int sum = 0;
                for (int weight : weights) {
                    sum += weight;
                    if (sum > mid) {
                        // 下一天
                        count++;
                        sum = weight;
                    }
                }
                if (count <= D) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return right;
        }
    }
}
