package com.leetcode.tag.top.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 */
public class Merge {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return intervals;
            }
            Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
            List<int[]> list = new ArrayList<>();
            list.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] ints = list.get(list.size() - 1);
                if (intervals[i][0] <= ints[1] && ints[1] < intervals[i][1]) {
                    ints[1] = intervals[i][1];
                } else if (intervals[i][0] > ints[1]) {
                    list.add(intervals[i]);
                }
            }

            return list.toArray(new int[0][]);
        }
    }
}
