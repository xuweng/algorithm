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

    class Solution1 {
        public int longestArithSeqLength(int[] A) {
            int n = A.length;
            // 特判
            if (n == 0) {
                return 0;
            }
            // 定义哈希表，第一个键表示数组下标索引，其嵌套的哈希表用于存储该元素以不同的公差所包含的最长序列
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            int res = 1;
            // 遍历数组
            for (int i = 0; i < n; i++) {
                map.put(i, new HashMap<>());
                // 向前遍历，寻找不同公差的最长序列
                for (int j = i - 1; j >= 0; j--) {
                    // 如果遇到了重复的元素，可以直接跳过，以为肯定不会比后面的元素能组成更长的序列
                    if (map.get(i).containsKey(A[i] - A[j])) {
                        continue;
                    }
                    // 获取以这两个元素差为公差的最长子序列
                    int cur = map.get(j).getOrDefault(A[i] - A[j], 0);
                    // 比较答案
                    res = Math.max(res, cur + 2);
                    // 存入当前元素，某公差下的最长序列
                    map.get(i).put(A[i] - A[j], cur + 1);
                }
            }

            return res;
        }
    }
}
