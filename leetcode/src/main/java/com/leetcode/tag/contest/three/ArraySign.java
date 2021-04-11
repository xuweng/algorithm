package com.leetcode.tag.contest.three;

/**
 * 5726. 数组元素积的符号
 */
public class ArraySign {
    class Solution {
        public int arraySign(int[] nums) {
            int c = 0;
            for (int num : nums) {
                if (num < 0) {
                    c++;
                }
                if (num == 0) {
                    return 0;
                }
            }

            if (c % 2 == 0) {
                return 1;
            }

            return -1;
        }
    }
}
