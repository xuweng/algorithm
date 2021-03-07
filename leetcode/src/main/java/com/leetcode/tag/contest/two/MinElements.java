package com.leetcode.tag.contest.two;

import java.util.Arrays;

/**
 * 5698. 构成特定和需要添加的最少元素
 */
public class MinElements {
    class Solution {
        public int minElements(int[] nums, int limit, int goal) {
            int sum = Arrays.stream(nums).sum();
            int i = goal - sum;
            if (i == 0) {
                return 0;
            } else if (i < 0) {
                int sum1 = 0;
                int count = 0;
                for (int j = -limit; j < 0; j++) {
                    if (i == j) {
                        return 1;
                    }
                    count++;
                    sum1 += j;
                    if (sum1 == i) {
                        return count;
                    }
                }
            } else {
                int sum1 = 0;
                int count = 0;
                for (int j = limit; j > 0; j--) {
                    if (i == j) {
                        return 1;
                    }
                    count++;
                    sum1 += j;
                    if (sum1 == i) {
                        return count;
                    }
                }
            }

            return 0;
        }
    }
}