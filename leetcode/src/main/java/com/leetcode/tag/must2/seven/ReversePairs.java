package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 51. 数组中的逆序对
 */
public class ReversePairs {
    class Solution {
        int count;

        public int reversePairs(int[] nums) {
            if (nums.length < 2) {
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
            int[] mergeLeft = merge(nums, left, mid);
            int[] mergeRight = merge(nums, mid + 1, right);

            int[] result = new int[mergeLeft.length + mergeRight.length];
            // 下标从0开始
            int i = 0;
            int j = 0;
            int r = 0;

            while (i < mergeLeft.length && j < mergeRight.length) {
                if (mergeLeft[i] <= mergeRight[j]) {
                    result[r++] = mergeLeft[i++];
                } else {
                    // i后面都是
                    count += mergeLeft.length - i;
                    result[r++] = mergeRight[j++];
                }
            }
            while (i < mergeLeft.length) {
                result[r++] = mergeLeft[i++];
            }
            while (j < mergeRight.length) {
                result[r++] = mergeRight[j++];
            }

            return result;
        }
    }
}
