package com.leetcode.tag.daily.seven;

/**
 * 189. 旋转数组
 */
public class Rotate {
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return;
            }
            for (int i = 0; i < k; i++) {
                int x = nums[nums.length - 1];
                System.arraycopy(nums, 0, nums, 1, nums.length - 2 + 1);
                nums[0] = x;
            }

        }
    }

    /**
     * 方法一：使用额外的数组
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            int[] newArr = new int[n];
            for (int i = 0; i < n; ++i) {
                // 新index (i + k) % n
                newArr[(i + k) % n] = nums[i];
            }
            System.arraycopy(newArr, 0, nums, 0, n);
        }
    }

}
