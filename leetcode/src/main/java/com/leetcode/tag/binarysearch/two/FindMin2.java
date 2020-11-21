package com.leetcode.tag.binarysearch.two;

/**
 * 153. 寻找旋转排序数组中的最小值
 * <p>
 * 头结点。头结点。头结点。头结点
 */
public class FindMin2 {
    static class Solution {
        public int findMin(int[] nums) {
            return bs(nums, 0, nums.length - 1);
        }

        /**
         * 取nums[low]还是nums[high]?
         *
         * @param nums
         * @param low
         * @param high
         * @return
         */
        private int bs(int[] nums, int low, int high) {
            if (low > high) {
                return -1;
            }
            int mid = low + (high - low) / 2;
            if (low == mid) {
                //low+1==high
                return Math.min(nums[low], nums[high]);
            }
            return nums[mid] > nums[high] ? bs(nums, mid + 1, high) : bs(nums, low, mid);
        }
    }

    /**
     * 看图
     * <p>
     * 看图。看图。看图。看图。看图。看图。看图。看图。看图。看图。看图。看图。看图。看图。看图。看图。看图。看图。
     * <p>
     * 合并函数
     * <p>
     * 合并函数
     * <p>
     * 合并函数.合并函数.合并函数.
     * <p>
     * 快慢指针.
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-by-leetcode-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int minArray(int[] numbers) {
            int low = 0;
            int high = numbers.length - 1;
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (numbers[pivot] < numbers[high]) {
                    high = pivot;
                } else if (numbers[pivot] > numbers[high]) {
                    low = pivot + 1;
                } else {
                    // 重复元素
                    // numbers[pivot]==numbers[high]
                    // 排除numbers[high]
                    high -= 1;
                }
            }
            return numbers[low];
        }
    }

}
