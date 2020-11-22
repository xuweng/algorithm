package com.leetcode.tag.binarysearch.two;

/**
 * 面试题 10.03. 搜索旋转数组
 */
public class Search {
    class Solution {
        public int search(int[] arr, int target) {
            return bs(arr, target, 0, arr.length - 1);
        }

        private int bs(int[] arr, int target, int low, int high) {
            if (low > high) {
                return -1;
            }
            int mid = low + (high - low) / 2;
            if (arr[low] < arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    return bs(arr, target, low, mid);
                }
                return bs(arr, target, mid + 1, high);
            } else if (arr[low] > arr[mid]) {
                if (arr[low] <= target || target <= arr[mid]) {
                    return bs(arr, target, low, mid);
                }
                return bs(arr, target, mid + 1, high);
            } else {
                return arr[low] == target ? low : bs(arr, target, low, high - 1);
            }
        }
    }
}
