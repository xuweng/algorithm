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
     * <p>
     * 数组中只有一个满足条件的答案
     * <p>
     * 因此我们可以使用二分查找在O(logn) 的时间内找到答案 0 所在的下标，具体做法就是碰到负数舍弃左半边，碰到正数舍弃右半边即可
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
