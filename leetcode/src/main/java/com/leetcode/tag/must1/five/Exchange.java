package com.leetcode.tag.must1.five;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Exchange {
    class Solution {
        public int[] exchange(int[] nums) {
            if (nums == null) {
                return nums;
            }
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                while (left < nums.length && nums[left] % 2 != 0) {
                    left++;
                }
                while (right >= 0 && nums[right] % 2 == 0) {
                    right--;
                }
                if (left != right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
            }

            return nums;
        }
    }
}
