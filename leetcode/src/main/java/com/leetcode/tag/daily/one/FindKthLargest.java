package com.leetcode.tag.daily.one;

/**
 * 划分区间
 * <p>
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest {
    /**
     * 选择区间
     */
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
            //两个区间:[l...j]和[j...r].k在哪个区间?
            if (r - j >= k) {
                //第二个区间元素过多
                //k在第二个区间.继续第k大.
                return quickSort(nums, j + 1, r, k);
            }
            //第一个区间元素过多
            //k在第一个区间.第k - (r - j)大.排除第二个区间的元素
            //1,2,3,4,5.第2大=第4小.第4大=第2小.
            return quickSort(nums, l, j, k - (r - j));
        }

        private void swap(int[] nums, int a, int b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }
}
