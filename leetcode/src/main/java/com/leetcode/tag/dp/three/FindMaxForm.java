package com.leetcode.tag.dp.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 474. 一和零
 * <p>
 * 贪心。排序。
 * <p>
 * 贪心。排序。
 * <p>
 * 贪心。排序。
 * <p>
 * 贪心。排序。
 * <p>
 * 贪心。排序。
 * <p>
 * 贪心。排序。贪心。排序。贪心。排序。贪心。排序。贪心。排序。
 * <p>
 * 贪心。排序。贪心。排序。贪心。排序。贪心。排序。
 * <p>
 * 思维有点乱。记录两个变量。
 */
public class FindMaxForm {
    /**
     * 是否以i结尾
     * <p>
     * 是否以i结尾
     * <p>
     * 是否以i结尾
     * <p>
     * 是否以i结尾
     */
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            if (strs == null || strs.length == 0) {
                return 0;
            }
            Map<Integer, Integer[]> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                int count0 = 0;
                int count1 = 0;
                for (int j = 0; j < strs[i].length(); j++) {
                    if (strs[i].charAt(j) == '0') {
                        count0++;
                    } else {
                        count1++;
                    }
                }
                Integer[] integers = new Integer[]{count0, count1};
                map.put(i, integers);
            }
            Map<Integer, Integer[]> dp = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                Integer[] integers = map.get(i);
                Integer[] integers1 = (integers[0] <= m && integers[1] <= n) ?
                        new Integer[]{integers[0], integers[1], 1} : new Integer[]{integers[0], integers[1], 0};
                dp.put(i, integers1);
                int max = integers1[2];
                for (int j = 0; j < i; j++) {
                    Integer[] integers2 = dp.get(j);
                    if (integers[0] + integers2[0] <= m && integers[1] + integers2[1] <= n) {
                        max = Math.max(max, integers2[2] + integers1[2]);
                    }
                }
            }

            return 0;
        }
    }
}
