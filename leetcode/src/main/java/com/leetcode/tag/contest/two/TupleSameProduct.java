package com.leetcode.tag.contest.two;

import java.util.Arrays;

/**
 * 5243. 同积元组
 */
public class TupleSameProduct {
    class Solution {
        public int tupleSameProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                int p = nums[i] * nums[nums.length - 1];
                int end = nums.length - 2;
                int j = i + 1;
                while (j <= end) {
                    int p1 = nums[j] * nums[end];
                    if (p == p1) {
                        result++;
                        break;
                    }
                    j++;
                    end--;
                }
            }

            return result * 8;
        }
    }
}
