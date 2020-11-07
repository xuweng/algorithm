package com.leetcode.tag.binarysearch.one;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * <p>
 * 排序数组中的搜索问题，首先想到 二分法 解决
 * <p>
 * 排序数组使用双指针也是高频选项
 */
public class MissingNumber {
    static class Solution {
        public int missingNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            return bs(nums, 0, nums.length - 1);
        }

        /**
         * 注意边界条件
         *
         * @param nums
         * @param low
         * @param high
         * @return
         */
        private int bs(int[] nums, int low, int high) {
            if (low > high) {
                return high + 1;
            }
            int mid = low + (high - low) / 2;
            if (nums[mid] != mid) {
                return mid;
            } else if (nums[mid] - nums[low] == mid - low) {
                // 栈溢出
                // (1,2)
                // bs(nums, mid, high);
                return bs(nums, mid + 1, high);
            } else {
                return bs(nums, low, mid - 1);
            }
        }
    }

    /**
     * 二分法
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int missingNumber(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == mid) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }

    class Solution2 {
        public int missingNumber(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            return bs(nums, 0, nums.length - 1);
        }

        private int bs(int[] nums, int left, int right) {
            if (left >= right) {
                return left;
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                bs(nums, mid + 1, right);
            } else {
                bs(nums, left, mid - 1);
            }
            return -1;
        }
    }

}
