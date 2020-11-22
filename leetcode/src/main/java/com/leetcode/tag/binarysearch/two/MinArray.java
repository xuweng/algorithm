package com.leetcode.tag.binarysearch.two;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * <p>
 * 理解记忆。理解记忆。理解记忆。理解记忆。理解记忆。理解记忆。理解记忆。
 * <p>
 * -a。-a。-a。-a。-a。-a。-a。
 * <p>
 * 理解记忆。理解记忆。理解记忆。理解记忆。理解记忆。理解记忆。理解记忆。
 */
public class MinArray {
    class Solution {
        public int minArray(int[] numbers) {
            return bs(numbers, 0, numbers.length - 1);
        }

        private int bs(int[] numbers, int low, int high) {
            if (low > high) {
                return -1;
            }
            int mid = low + (high - low) / 2;
            if (low == mid) {
                // 只有两个元素
                return Math.min(numbers[low], numbers[high]);
            }
            if (numbers[mid] < numbers[high]) {
                return bs(numbers, low, mid);
            } else if (numbers[mid] > numbers[high]) {
                return bs(numbers, mid + 1, high);
            } else {
                // 重复元素
                return bs(numbers, low, high - 1);
            }
        }
    }
}
