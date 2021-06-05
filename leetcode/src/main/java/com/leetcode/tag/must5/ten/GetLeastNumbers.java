package com.leetcode.tag.must5.ten;

/**
 * 剑指 Offer 40. 最小的k个数
 */
public class GetLeastNumbers {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
                return new int[0];
            }
            int index = getIndex(arr, k, 0, arr.length - 1);
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = arr[i];
            }

            return result;
        }

        private int getIndex(int[] arr, int k, int left, int right) {
            int p = partition(arr, left, right);
            if (p == k - 1) {
                return p;
            }
            if (p > k - 1) {
                // 缩小区间
                return getIndex(arr, k, left, p - 1);
            }
            // 扩大区间
            return getIndex(arr, k, p + 1, right);
        }

        private int partition(int[] arr, int left, int right) {
            if (left >= right) {
                return left;
            }
            int p = arr[left];
            while (left < right) {
                while (left < right && arr[right] >= p) {
                    right--;
                }
                if (left < right) {
                    arr[left] = arr[right];
                }
                while (left < right && arr[left] < p) {
                    left++;
                }
                if (left < right) {
                    arr[right] = arr[left];
                }
            }
            arr[left] = p;
            return left;
        }
    }
}
