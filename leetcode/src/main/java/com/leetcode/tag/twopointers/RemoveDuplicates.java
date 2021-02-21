package com.leetcode.tag.twopointers;

/**
 * 26. 删除排序数组中的重复项
 */
public class RemoveDuplicates {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[left] != nums[i]) {
                    nums[++left] = nums[i];
                }
            }

            return left + 1;
        }
    }

    /**
     * 方法：双指针法
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-xiang-by-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}
