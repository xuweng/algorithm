package com.leetcode.tag.must2.six;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * <p>
 * 创建新数组
 */
public class SingleNumbers {
    /**
     * 方法一：分组异或
     * <p>
     * 可以把所有数字分成两组，使得：
     * <p>
     * 1.两个只出现一次的数字在不同的组中；
     * <p>
     * 2.相同的数字会被分到相同的组中。
     */
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int ret = 0;
            for (int n : nums) {
                ret ^= n;
            }
            int div = 1;
            while ((div & ret) == 0) {
                div <<= 1;
            }
            int a = 0, b = 0;
            for (int n : nums) {
                if ((div & n) != 0) {
                    a ^= n;
                } else {
                    b ^= n;
                }
            }
            return new int[]{a, b};
        }
    }
}
