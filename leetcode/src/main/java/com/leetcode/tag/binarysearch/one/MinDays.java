package com.leetcode.tag.binarysearch.one;

import java.util.Arrays;

/**
 * 1482. 制作 m 束花所需的最少天数
 */
public class MinDays {
    /**
     * 作者：feng-qi-feng-luo
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/solution/java-er-fen-dai-zhu-shi-by-feng-qi-feng-luo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            if (m * k > bloomDay.length) {
                return -1;
            }
            // 最大等待的天数是数组里的最大值
            int max = Arrays.stream(bloomDay).max().orElse(0);
            // 最小等待0天
            int min = 0;
            while (min < max) {
                // mid:等待天数
                int mid = min + (max - min) / 2;
                // 等待mid天，有多少组连续的k朵花已经开花🌼了
                int count = getCount(bloomDay, mid, k);
                if (count >= m) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return min;
        }

        // 返回等待day天，有多少组连续的k天<=day  这里用的贪心
        private int getCount(int[] arr, int day, int k) {
            int re = 0;
            int count = 0;
            for (int j : arr) {
                if (j <= day) {
                    count++;
                } else {
                    count = 0;
                }
                //  连续的k朵花🌼开了
                if (count == k) {
                    re++;
                    count = 0;
                }
            }
            return re;
        }
    }

}
