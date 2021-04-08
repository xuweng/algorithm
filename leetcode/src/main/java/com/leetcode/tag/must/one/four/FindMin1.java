package com.leetcode.tag.must.one.four;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * <p>
 * 注意数组中可能存在重复的元素。
 */
public class FindMin1 {
    class Solution {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                    // 三者相等
                    right--;
                } else if (nums[mid] <= nums[right]) {
                    //nums[mid] = nums[right]
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return nums[left];
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-de-zui--16/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (nums[pivot] < nums[high]) {
                    high = pivot;
                } else if (nums[pivot] > nums[high]) {
                    low = pivot + 1;
                } else {
                    high -= 1;
                }
            }
            return nums[low];
        }
    }

}
