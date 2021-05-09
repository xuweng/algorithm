package com.leetcode.tag.contest.three;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 5750. 人口最多的年份
 */
public class MaximumPopulation {
    class Solution {
        public int maximumPopulation(int[][] logs) {
            Arrays.stream(logs).sorted(Comparator.comparing(l -> l[0]));

            int max = 1;
            int max1 = 1;
            int result = logs[0][0];
            int last = 0;
            for (int i = 1; i < logs.length; i++) {
                if (logs[i][0] < logs[last][1]) {
                    max++;
                } else {
                    max = 1;
                    last = i;
                }
                if (max1 < max) {
                    result = logs[last][0];
                    max1 = max;
                } else {
                    result = logs[i][0];
                }
            }

            return result;
        }
    }
}
