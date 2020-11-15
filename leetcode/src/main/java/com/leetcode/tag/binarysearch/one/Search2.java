package com.leetcode.tag.binarysearch.one;

/**
 * 面试题 10.03. 搜索旋转数组
 * <p>
 * 思维缜密。处处是细节。思维缜密。思维缜密。
 * <p>
 * 最左边连续字符为0.
 * <p>
 * 脑里模拟。脑里模拟。脑里模拟。脑里模拟。脑里模拟。脑里模拟。脑里模拟。脑里模拟。
 * <p>
 * 思维缜密。思维缜密。思维缜密。思维缜密。思维缜密。思维缜密。思维缜密。
 */
public class Search2 {
    static class Solution {
        public int search(int[] arr, int target) {
            if (arr == null || arr.length == 0) {
                return -1;
            }
            return bs(arr, target, 0, arr.length - 1);
        }

        private int bs(int[] arr, int target, int low, int high) {
            if (low > high) {
                return -1;
            }
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                //若有多个相同元素，返回索引值最小的一个。
                return mid >= 1 && arr[mid - 1] == target ? bs(arr, target, low, mid - 1) : mid;
            }
            if (arr[low] < arr[mid]) {
                // mid在左区间
                if (arr[low] <= target && target <= arr[mid]) {
                    return bs(arr, target, low, mid);
                }
                return bs(arr, target, mid + 1, high);

            } else if (arr[low] > arr[mid]) {
                // mid在右区间
                if (arr[low] <= target || target <= arr[mid]) {
                    return bs(arr, target, low, mid);
                }
                return bs(arr, target, mid + 1, high);
            } else {
                // low和mid相等.
                return arr[low] == target ? low : bs(arr, target, low + 1, high);
            }
        }
    }
}
