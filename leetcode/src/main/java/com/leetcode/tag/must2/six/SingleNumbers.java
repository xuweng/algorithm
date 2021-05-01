package com.leetcode.tag.must2.six;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * <p>
 * 创建新数组
 */
public class SingleNumbers {
    /**
     * 方法一：分组异或
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
