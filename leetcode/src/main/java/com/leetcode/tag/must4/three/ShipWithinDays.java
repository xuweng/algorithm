package com.leetcode.tag.must4.three;

import java.util.Arrays;

/**
 * i j 模型
 * <p>
 * i j k 模型
 * <p>
 * 1011. 在 D 天内送达包裹的能力
 */
public class ShipWithinDays {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int left = Arrays.stream(weights).max().getAsInt();
            int right = Arrays.stream(weights).sum();

            while (left < right) {
                int mid = left + (right - left) / 2;
                int tian = 1;
                int sum = 0;

                for (int weight : weights) {
                    sum += weight;
                    if (sum > mid) {
                        tian++;
                        sum = weight;
                    }
                }
                if (tian <= days) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }
}
