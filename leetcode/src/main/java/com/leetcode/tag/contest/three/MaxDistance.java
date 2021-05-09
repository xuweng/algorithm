package com.leetcode.tag.contest.three;

/**
 * 5751. 下标对中的最大距离
 */
public class MaxDistance {
    class Solution {
        public int maxDistance(int[] nums1, int[] nums2) {
            int result = 0;
            for (int i = 0; i < nums1.length; i++) {
                for (int j = i; j < nums2.length; j++) {
                    if (nums1[i] <= nums2[j]) {
                        result = Math.max(result, j - i);
                    }
                }
            }

            return result;
        }
    }
}
