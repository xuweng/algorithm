package com.leetcode.tag.contest.two;

/**
 * 5724. 绝对差值和
 */
public class MinAbsoluteSumDiff {
    class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            if (nums1 == null || nums2 == null) {
                return 0;
            }
            int cha = 0;
            int index = 0;
            for (int i = 0; i < nums1.length; i++) {
                if (cha < Math.abs(nums1[i] - nums2[i])) {
                    cha = Math.abs(nums1[i] - nums2[i]);
                    index = i;
                }
            }

            int s = Integer.MAX_VALUE;
            for (int i = 0; i < nums1.length; i++) {
                s = Math.min(s, Math.abs(nums1[i] - nums2[index]));
            }

            int sum = 0;
            for (int i = 0; i < nums1.length; i++) {
                if (i == index) {
                    sum += s;
                } else {
                    sum += Math.abs(nums1[i] - nums2[i]);
                }
            }

            return sum;
        }
    }
}
