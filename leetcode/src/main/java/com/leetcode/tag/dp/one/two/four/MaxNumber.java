package com.leetcode.tag.dp.one.two.four;

/**
 * 321. 拼接最大数
 */
public class MaxNumber {
    /**
     * 选中i?前i?
     */
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int[][][] dp = new int[nums1.length + 1][nums2.length + 1][k + 1];


            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    for (int l = 1; l <= k; l++) {
                        if (nums1[i] == nums2[j]) {

                        }
                    }
                }
            }

            return nums1;
        }

    }
}
