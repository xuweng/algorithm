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
}
