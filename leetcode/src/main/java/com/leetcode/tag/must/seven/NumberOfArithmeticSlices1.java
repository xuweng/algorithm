package com.leetcode.tag.must.seven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 446. 等差数列划分 II - 子序列
 */
public class NumberOfArithmeticSlices1 {
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if (nums == null) {
                return 0;
            }
            Map<Long, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.computeIfAbsent((long) nums[i], v -> new ArrayList<>()).add(i);
            }
            int sum = 0;
            int[][] dp = new int[nums.length][nums.length];
            for (int i = 2; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    long key = 2 * (long) nums[j] - (long) nums[i];
                    if (!map.containsKey(key)) {
                        continue;
                    }
                    List<Integer> list = map.get(key);
                    for (Integer k : list) {
                        // k<j<i
                        if (k < j) {
                            dp[i][j] += dp[j][k] + 1;
                        }
                    }
                    sum += dp[i][j];
                }
            }

            return sum;
        }
    }
}
