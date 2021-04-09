package com.leetcode.tag.must.three;

/**
 * 88. 合并两个有序数组
 */
public class Merge {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (nums1 == null) {
                return;
            }
            int i = m - 1;
            int j = n - 1;
            int len = m + n - 1;
            while (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums1[len--] = nums1[i--];
                } else {
                    nums1[len--] = nums2[j--];
                }
            }
            while (j >= 0) {
                nums1[len--] = nums2[j--];
            }
        }
    }
}
