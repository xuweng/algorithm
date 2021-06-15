package com.leetcode.tag.must6.five;

/**
 * 852. 山脉数组的峰顶索引
 */
public class PeakIndexInMountainArray {
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int left = 0;
            int right = arr.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid + 1] > arr[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }

    class Solution1 {
        public int peakIndexInMountainArray(int[] arr) {
            int left = 0;
            int right = arr.length - 1;

            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (arr[mid] > arr[mid - 1]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }
    }
}
