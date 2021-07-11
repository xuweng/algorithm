package com.leetcode.tag.must7.two;

import java.util.Arrays;

/**
 * 274. H 指数
 */
public class HIndex {
    /**
     * 方法一：排序
     */
    class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);

            int h = 0, i = citations.length - 1;
            while (i >= 0 && citations[i] > h) {
                h++;
                i--;
            }
            return h;
        }
    }

    /**
     * 方法二：计数排序
     */
    class Solution1 {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] counter = new int[n + 1];
            for (int citation : citations) {
                if (citation >= n) {
                    counter[n]++;
                } else {
                    counter[citation]++;
                }
            }
            int tot = 0;
            for (int i = n; i >= 0; i--) {
                tot += counter[i];
                if (tot >= i) {
                    return i;
                }
            }
            return 0;
        }
    }
}
