package com.leetcode.tag.twopointers;

/**
 * 27. 移除元素
 */
public class RemoveElement {
    class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[left++] = nums[i];
                }
            }

            return left;
        }
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/remove-element/solution/yi-chu-yuan-su-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int removeElement(int[] nums, int val) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
    }
}
