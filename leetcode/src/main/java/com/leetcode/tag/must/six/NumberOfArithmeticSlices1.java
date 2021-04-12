package com.leetcode.tag.must.six;

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
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Map<Long, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.computeIfAbsent((long) nums[i], v -> new ArrayList<>()).add(i);
            }
            // 个数 个数 个数
            int[][] dp = new int[nums.length][nums.length];
            int sum = 0;
            for (int i = 2; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    // 计算key是重点
                    long key = 2 * (long) nums[j] - (long) nums[i];
                    if (!map.containsKey(key)) {
                        continue;
                    }
                    List<Integer> list = map.get(key);
                    for (Integer k : list) {
                        if (k < j) {
                            // 注意累加
                            dp[i][j] += dp[j][k] + 1;
                        }
                    }
                    sum += dp[i][j];
                }
            }

            return sum;
        }
    }

    class Solution1 {
        public int numberOfArithmeticSlices(int[] A) {
            //--改进：以dp[i][j]表示以A[i]-A[j]为公差
            //--得到：dp[i][j] = dp[j][k] + 1（A[i]-A[j] == A[j]-A[k]）
            int[][] dp = new int[A.length][A.length];
            int res = 0;
            //k怎么得到：遍历前n个数或者用HashMap预处理
            //--直接存储HashMap<A[i], i>的话，发现用例有重复 --> 用集合存储重复的A[i]
            //--还要考虑i、j、k的大小关系：i > j > k

            // 1, 1, 1, 2, 5, 7
            // [2, 4, 6, 8, 10]
            // [2, 2, 2, 2, 4, 6, 8, 10]
            HashMap<Long, List<Integer>> checkup = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                // 保存下标
                // v,index
                checkup.computeIfAbsent((long) A[i], v -> new ArrayList<>()).add(i);
            }
            for (int i = 2; i < A.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    // [2, 2, 2, 2, 4, 6, 8, 10]
                    // [2, 2, 2, 2, 4, 6]
                    // 计算key 计算下一个等差数字 2 * (long) A[j] 厉害
                    long key = 2 * (long) A[j] - (long) A[i];
                    if (!checkup.containsKey(key)) {
                        continue;
                    }
                    // [2, 2, 2, 2]
                    // 等差数字的索引集合
                    List<Integer> list = checkup.get(key);
                    for (int index : list) {
                        // 或者排序
                        // 必须index < j 才合法 index<j<i
                        if (index < j) {
                            //A[i]-A[j] == A[j]-A[index]
                            dp[i][j] += dp[j][index] + 1;
                        }
                    }
                    res += dp[i][j];
                }
            }
            return res;
        }
    }
}
