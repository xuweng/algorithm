package com.leetcode.tag.must.nine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1027. 最长等差数列
 */
public class LongestArithSeqLength {
    class Solution {
        public int longestArithSeqLength(int[] A) {
            Map<Long, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                map.computeIfAbsent((long) A[i], v -> new ArrayList<>()).add(i);
            }
            int max = 0;
            int[][] dp = new int[A.length][A.length];
            for (int i = 2; i < A.length; i++) {
                for (int j = 0; j < i; j++) {
                    long key = 2 * (long) A[j] - (long) A[i];
                    if (!map.containsKey(key)) {
                        continue;
                    }
                    List<Integer> list = map.get(key);
                    for (Integer k : list) {
                        // k<j<i
                        if (k < j) {
                            dp[i][j] = Math.max(dp[i][j], dp[j][k] + 1);
                        }
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }

            return max;
        }
    }
}
