package com.leetcode.tag.dp.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 474. 一和零
 * <p>
 * 感觉 感觉 感觉 感觉 感觉 感觉 感觉 感觉 感觉
 * <p>
 * 递归树 递归树 递归树 递归树
 */
public class FindMaxForm1 {
    /**
     * 子集累加计数 子集累加计数 子集累加计数
     * <p>
     * 不是这样做 不是这样做 不是这样做
     */
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            Map<Integer, Integer[]> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                Integer[] integers = map.getOrDefault(i, new Integer[2]);
                int count0 = 0;
                int count1 = 0;
                String str = strs[i];
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '0') {
                        count0++;
                    } else {
                        count1++;
                    }
                }
                integers[0] = count0;
                integers[1] = count1;
            }

            int[] dp = new int[strs.length];
            Integer[] integers = map.get(0);
            dp[0] = (integers[0] <= m && integers[1] <= n) ? 1 : 0;
            for (int i = 1; i < strs.length; i++) {
                Integer[] integers2 = map.get(i);
                for (int j = 0; j < i; j++) {
                    Integer[] integers1 = map.get(j);
                }
            }
            return 0;
        }
    }
}
