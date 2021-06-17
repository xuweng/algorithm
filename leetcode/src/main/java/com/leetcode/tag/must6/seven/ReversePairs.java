package com.leetcode.tag.must6.seven;

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
            int[] l = merge(nums, left, mid);
            int[] r = merge(nums, mid + 1, right);
            int[] result = new int[l.length + r.length];

            int i = 0;
            int j = 0;
            int re = 0;

            while (i < l.length && j < r.length) {
                if (l[i] <= r[j]) {
                    result[re++] = l[i++];
                } else {
                    count += l.length - i;
                    result[re++] = r[j++];
                }
            }
            while (i < l.length) {
                result[re++] = l[i++];
            }
            while (j < r.length) {
                result[re++] = r[j++];
            }

            return result;
        }
    }
}
