package com.leetcode.tag.must.five;

/**
 * 5726. 数组元素积的符号
 */
public class ArraySign {
    class Solution {
        public int arraySign(int[] nums) {
            int result = 1;
            for (int num : nums) {
                if (num == 0) {
                    return 0;
                }
                result *= (num > 0) ? 1 : -1;
            }

            return result;
        }
    }
}
