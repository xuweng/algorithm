package com.leetcode.tag.daily.five;

/**
 * 283. 移动零
 */
public class MoveZeroes {
    /**
     * 方法一：双指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public void moveZeroes(int[] nums) {
            int n = nums.length;
            //左指针左边均为非零数
            int left = 0;
            //右指针左边直到左指针处均为零
            int right = 0;
            while (right < n) {
                if (nums[right] != 0) {
                    //每次交换，都是将左指针的零与右指针的非零数交换
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }

        public void swap(int[] nums, int left, int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }

}
