package com.leetcode.tag.daily.five;

/**
 * 283. 移动零
 * <p>
 * 看图。
 * <p>
 * 指向0，指向非0
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

    /**
     * 参考了快速排序的思想
     * <p>
     * 可以用0当做这个point，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
     * <p>
     * 作者：wang_ni_ma
     * 链接：https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public void moveZeroes(int[] nums) {
            if (nums == null) {
                return;
            }
            //两个指针i和j
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                //当前元素!=0，就把其交换到左边，等于0的交换到右边
                if (nums[i] != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = tmp;
                }
            }
        }
    }

}
