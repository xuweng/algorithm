package com.leetcode.tag.must3.five;

/**
 * 剑指 Offer 51. 数组中的逆序对
 */
public class ReversePairs {
    class Solution {
        int count;

        public int reversePairs(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            merge(nums, 0, nums.length - 1);

            return count;
        }

        private int[] merge(int[] nums, int left, int right) {
            if (left >= right) {
                return new int[]{nums[left]};
            }
            int mid = left + (right - left) / 2;
            int[] mergeL = merge(nums, left, mid);
            int[] mergeR = merge(nums, mid + 1, right);
            int[] result = new int[mergeL.length + mergeR.length];

            int i = 0;
            int j = 0;
            int r = 0;

            while (i < mergeL.length && j < mergeR.length) {
                if (mergeL[i] <= mergeR[j]) {
                    result[r++] = mergeL[i++];
                } else {
                    // i和i的后面都是
                    count += mergeL.length - i;
                    result[r++] = mergeR[j++];
                }
            }
            while (i < mergeL.length) {
                result[r++] = mergeL[i++];
            }
            while (j < mergeR.length) {
                result[r++] = mergeR[j++];
            }

            return result;
        }
    }
}
