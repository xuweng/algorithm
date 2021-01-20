package com.leetcode.tag.daily.seven;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 */
public class MaximumProduct {
    /**
     * 方法一：排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers/solution/san-ge-shu-de-zui-da-cheng-ji-by-leetcod-t9sb/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            //分别求出三个最大正数的乘积，以及两个最小负数与最大正数的乘积，二者之间的最大值
            return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
        }
    }

    /**
     * 方法二：线性扫描
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers/solution/san-ge-shu-de-zui-da-cheng-ji-by-leetcod-t9sb/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int maximumProduct(int[] nums) {
            // 最小的和第二小的
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            // 最大的、第二大的和第三大的
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

            for (int x : nums) {
                if (x < min1) {
                    min2 = min1;
                    min1 = x;
                } else if (x < min2) {
                    min2 = x;
                }

                if (x > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = x;
                } else if (x > max2) {
                    max3 = max2;
                    max2 = x;
                } else if (x > max3) {
                    max3 = x;
                }
            }

            return Math.max(min1 * min2 * max1, max1 * max2 * max3);
        }
    }

}
