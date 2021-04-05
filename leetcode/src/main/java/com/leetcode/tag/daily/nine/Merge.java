package com.leetcode.tag.daily.nine;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 */
public class Merge {
    class Solution {
        /**
         * 方法一：直接合并后排序
         *
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0; i != n; ++i) {
                nums1[m + i] = nums2[i];
            }
            Arrays.sort(nums1);
        }
    }
}
