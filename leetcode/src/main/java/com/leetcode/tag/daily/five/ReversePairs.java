package com.leetcode.tag.daily.five;

/**
 * 493. 翻转对
 */
public class ReversePairs {
    /**
     * 方法一：归并排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-pairs/solution/fan-zhuan-dui-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int reversePairs(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            return reversePairsRecursive(nums, 0, nums.length - 1);
        }

        /**
         * 则 nums[l..r] 中的翻转对数目，就等于两个子数组的翻转对数目之和，加上左右端点分别位于两个子数组的翻转对数目。
         * <p>
         * [left,mid],[mid,right],[left,right]
         *
         * @param nums
         * @param left
         * @param right
         * @return
         */
        public int reversePairsRecursive(int[] nums, int left, int right) {
            if (left == right) {
                return 0;
            }
            int mid = (left + right) / 2;
            //将两个子数组分别排好序
            int n1 = reversePairsRecursive(nums, left, mid);
            //将两个子数组分别排好序
            int n2 = reversePairsRecursive(nums, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int j = mid + 1;
            while (i <= mid) {
                while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                    j++;
                }
                ret += j - mid - 1;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = nums[p2++];
                } else if (p2 > right) {
                    sorted[p++] = nums[p1++];
                } else {
                    if (nums[p1] < nums[p2]) {
                        sorted[p++] = nums[p1++];
                    } else {
                        sorted[p++] = nums[p2++];
                    }
                }
            }
            System.arraycopy(sorted, 0, nums, left, sorted.length);
            return ret;
        }
    }

}
