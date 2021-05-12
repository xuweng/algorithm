package com.leetcode.tag.must3.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 */
public class FindContinuousSequence {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int left = 1;
            int right = 1;
            int sum = 0;

            List<int[]> list = new ArrayList<>();
            while (left <= target / 2) {
                if (sum < target) {
                    sum += right;
                    right++;
                } else if (sum > target) {
                    sum -= left;
                    left++;
                } else {
                    int[] a = new int[right - left];
                    for (int i = left; i < right; i++) {
                        a[i - left] = i;
                    }
                    list.add(a);
                    sum -= left;
                    left++;
                }
            }

            return list.toArray(new int[list.size()][]);
        }
    }
}
