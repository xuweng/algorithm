package com.leetcode.tag.daily;

/**
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSort(nums, 0, nums.length - 1, k);
        }

        private int quickSort(int[] nums, int l, int r, int k) {
            //数组只有一个元素
            if (l >= r) return nums[l];
            //-1?,+1?
            int i = l - 1, j = r + 1;
            int x = nums[l + r >> 1];
            while (i < j) {
                do {
                    i++;
                } while (nums[i] < x);
                do {
                    j--;
                } while (nums[j] > x);
                if (i < j) {
                    swap(nums, i, j);
                }
            }

            //j是分区
            //两个区间:[i...j]和[j...r].k在哪个区间?
            if (r - j >= k) {
                //k在第二个区间
                return quickSort(nums, j + 1, r, k);
            }
            //k在第一个区间
            return quickSort(nums, l, j, k - r + j);
        }

        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}
