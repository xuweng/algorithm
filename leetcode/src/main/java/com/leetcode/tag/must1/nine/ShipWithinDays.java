package com.leetcode.tag.must1.nine;

import java.util.Arrays;

/**
 * 1011. 在 D 天内送达包裹的能力
 */
public class ShipWithinDays {
    /**
     * 方法一：二分查找转化为判定问题
     */
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            // 确定二分查找左右边界
            // 左边界而言，由于我们不能「拆分」一个包裹，因此船的运载能力不能小于所有包裹中最重的那个的重量，
            // 即左边界为数组 weights 中元素的最大值
            int left = Arrays.stream(weights).max().getAsInt();
            // 右边界而言，船的运载能力也不会大于所有包裹的重量之和，即右边界为数组  weights 中元素的和
            int right = Arrays.stream(weights).sum();
            // 从上述左右边界开始进行二分查找，就可以保证找到最终的答案
            while (left < right) {
                int mid = (left + right) / 2;
                // need 为需要运送的天数
                int need = 1;
                // cur 为当前这一天已经运送的包裹重量之和
                int cur = 0;
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
