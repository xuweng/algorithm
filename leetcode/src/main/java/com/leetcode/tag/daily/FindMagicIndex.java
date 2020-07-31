package com.leetcode.tag.daily;

/**
 * 面试题 08.03. 魔术索引
 */
public class FindMagicIndex {
    class Solution {
        public int findMagicIndex(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == i) {
                    return i;
                }
            }
            return -1;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/magic-index-lcci/solution/mo-zhu-suo-yin-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int findMagicIndex(int[] nums) {
            return getAnswer(nums, 0, nums.length - 1);
        }

        public int getAnswer(int[] nums, int left, int right) {
            if (left > right) {
                return -1;
            }
            int mid = (right - left) / 2 + left;
            int leftAnswer = getAnswer(nums, left, mid - 1);
            if (leftAnswer != -1) {
                return leftAnswer;
            } else if (nums[mid] == mid) {
                return mid;
            }
            return getAnswer(nums, mid + 1, right);
        }
    }

}
