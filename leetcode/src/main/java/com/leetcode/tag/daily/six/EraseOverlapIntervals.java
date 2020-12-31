package com.leetcode.tag.daily.six;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 */
public class EraseOverlapIntervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

            int result = 1;
            int last = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < last) {
                    result++;
                } else {
                    last = intervals[i][1];
                }
            }

            return result;
        }
    }
}
