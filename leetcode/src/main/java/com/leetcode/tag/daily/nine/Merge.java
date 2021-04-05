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

    /**
     * 方法二：双指针
     * <p>
     * 已经被排序的性质
     */
    class Solution1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = 0, p2 = 0;
            int[] sorted = new int[m + n];
            int cur;
            while (p1 < m || p2 < n) {
                if (p1 == m) {
                    cur = nums2[p2++];
                } else if (p2 == n) {
                    cur = nums1[p1++];
                } else if (nums1[p1] < nums2[p2]) {
                    cur = nums1[p1++];
                } else {
                    cur = nums2[p2++];
                }
                sorted[p1 + p2 - 1] = cur;
            }
            for (int i = 0; i != m + n; ++i) {
                nums1[i] = sorted[i];
            }
        }
    }

    /**
     * 从后向前数组遍历
     */
    class Solution2 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //len1 指向 nums1 的有数字尾部
            int len1 = m - 1;
            //len2 指向 nums2 的有数字尾部
            int len2 = n - 1;
            // len 指向 nums1 的最末尾
            int len = m + n - 1;
            while (len1 >= 0 && len2 >= 0) {
                // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
                if (nums1[len1] > nums2[len2]) {
                    nums1[len--] = nums1[len1--];
                } else {
                    nums1[len--] = nums2[len2--];
                }
            }
            // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
            System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        }
    }
}
