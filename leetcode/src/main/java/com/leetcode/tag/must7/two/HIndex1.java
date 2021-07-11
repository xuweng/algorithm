package com.leetcode.tag.must7.two;

/**
 * 275. H 指数 II
 */
public class HIndex1 {
    /**
     * 方法一：线性搜索
     */
    class Solution {
        public int hIndex(int[] citations) {
            int idx = 0, n = citations.length;
            for (int c : citations) {
                if (c >= n - idx) {
                    // 只需要找到第一篇文章 c = citation[i] 大于或等于 n - idx
                    // 有 n-idx 个文章引用次数至少为 c 次
                    return n - idx;
                } else {
                    idx++;
                }
            }
            return 0;
        }
    }
}
