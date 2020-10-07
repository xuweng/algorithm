package com.leetcode.tag.daily.three;

import java.util.Arrays;

/**
 * 75. 颜色分类
 */
public class SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            Arrays.sort(nums);
        }
    }

    class Solution1 {
        public void sortColors(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            int[] array = new int[3];
            for (int num : nums) {
                array[num]++;
            }
            int index = 0;
            for (int j = 0; j < array.length; j++) {
                int i = array[j];
                while (i-- > 0) {
                    nums[index++] = j;
                }
            }
        }
    }

    /**
     * 方法一：单指针
     * <p>
     * 思路与算法
     * <p>
     * 我们可以考虑对数组进行两次遍历。在第一次遍历中，我们将数组中所有的 0 交换到数组的头部。
     * <p>
     * 在第二次遍历中，我们将数组中所有的 1 交换到头部的 0 之后。此时，所有的 2 都出现在数组的尾部，这样我们就完成了排序。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int ptr = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[ptr];
                    nums[ptr++] = temp;
                }
            }
            //此时前ptr都是0
            for (int i = ptr; i < n; ++i) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[ptr];
                    nums[ptr++] = temp;
                }
            }
        }
    }

    /**
     * 方法二：双指针
     * <p>
     * 指针划分区间
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public void sortColors(int[] nums) {
            int n = nums.length;
            //[0,p0)是0
            //[p0,p1)是1
            //指向0.0的分割线.
            int p0 = 0;
            //指向1.1的分割线.
            int p1 = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                    ++p1;
                } else if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = temp;
                    if (p0 < p1) {
                        temp = nums[i];
                        nums[i] = nums[p1];
                        nums[p1] = temp;
                    }
                    ++p0;
                    ++p1;
                }
            }
        }
    }

}
