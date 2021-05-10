package com.leetcode.tag.must3.four;

/**
 * 剑指 Offer 40. 最小的k个数
 * <p>
 * 归并 归并 归并
 * <p>
 * 快排 快排 快排
 * <p>
 * 退出循环 退出循环 退出循环 代码掌控 代码掌控
 */
public class GetLeastNumbers {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr == null || arr.length == 0 || k == 0 || k > arr.length) {
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
            int p = partion(arr, left, right);
            if (p == k - 1) {
                // [0,p] [0,k-1] top k
                return p;
            }
            if (p > k - 1) {
                // 缩小区间
                return getIndex(arr, k, left, p - 1);
            }
            // 扩大区间
            return getIndex(arr, k, p + 1, right);
        }

        private int partion(int[] arr, int left, int right) {
            if (left >= right) {
                return left;
            }
            int p = arr[left];
            while (left < right) {
                // >=p right
                while (left < right && arr[right] >= p) {
                    right--;
                }
                // 移动
                if (left < right) {
                    arr[left] = arr[right];
                }
                // <p left
                while (left < right && arr[left] < p) {
                    left++;
                }
                // 移动
                if (left < right) {
                    arr[right] = arr[left];
                }
            }
            // 123456 513789
            // arr[right]<=p left<=right arr[left] <= p
            arr[left] = p;
            return left;
        }
    }
}
