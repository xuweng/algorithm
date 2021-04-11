package com.leetcode.tag.contest.three;

/**
 * 5726. 数组元素积的符号
 */
public class ArraySign {
    class Solution {
        public int arraySign(int[] nums) {
            int c = 1;
            for (int num : nums) {
                c = c * num;
            }

            if (c > 0) {
                return 1;
            }
            if (c < 0) {
                return -1;
            }
            return 0;
        }
    }
}
