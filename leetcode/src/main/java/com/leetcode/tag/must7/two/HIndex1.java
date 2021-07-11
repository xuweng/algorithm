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

    /**
     * 方法二：二分搜索
     */
    class Solution1 {
        public int hIndex(int[] citations) {
            int n = citations.length;
            // [0,n-1]
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (citations[mid] == n - mid) {
                    return n - mid;
                }
                if (citations[mid] < n - mid) {
                    // 扩大
                    left = mid + 1;
                } else {
                    // 缩小
                    right = mid - 1;
                }
            }

            return n - left;
        }
    }

    class Solution2 {
        public int hIndex(int[] citations) {
            int n = citations.length;
            // [0,n)
            int left = 0, right = n;
            while (left < right) {
                int mid = (right + left) / 2;
                if (citations[mid] == n - mid) {
                    return n - mid;
                }
                // 排除mid
                if (citations[mid] < n - mid) {
                    // 扩大
                    left = mid + 1;
                } else {
                    // 缩小
                    right = mid;
                }
            }

            return n - left;
        }
    }
}
