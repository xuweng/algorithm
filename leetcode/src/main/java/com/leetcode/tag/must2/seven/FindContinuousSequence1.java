package com.leetcode.tag.must2.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 */
public class FindContinuousSequence1 {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int left = 1;
            int right = 1;
            int sum = 0;

            List<int[]> result = new ArrayList<>();
            while (left <= target / 2) {
                if (sum < target) {
                    sum += right;
                    right++;
                } else if (sum > target) {
                    sum -= left;
                    left++;
                } else {
                    // 此时right在sum外
                    int[] ints = new int[right - left];
                    for (int i = left; i < right; i++) {
                        ints[i - left] = i;
                    }
                    result.add(ints);

                    sum -= left;
                    left++;
                }
            }

            return (int[][]) result.toArray();
        }
    }
}
