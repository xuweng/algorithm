package com.leetcode.tag.contest;

import java.util.stream.IntStream;

/**
 * 5500. 乘积为正数的最长子数组长度
 * <p>
 * 一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组
 * <p>
 * 搞懂题目
 * <p>
 * 搞懂题目
 */
public class GetMaxLen {
    class Solution {
        public int getMaxLen(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    continue;
                }
                for (int j = i; j < nums.length; j++) {
                    int count = count(nums, i, j);
                    if (count % 2 == 0) {
                        max = Math.max(max, j - i + 1);
                    }
                }
            }

            return max;
        }

        private int count(int[] nums, int start, int end) {
            return (int) IntStream.rangeClosed(start, end).filter(i -> nums[i] < 0).count();
        }
    }
}
