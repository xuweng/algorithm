package com.leetcode.tag.contest.two;

import java.util.Arrays;

/**
 * 5641. 卡车上的最大单元数
 */
public class MaximumUnits {
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            if (boxTypes == null || boxTypes.length == 0) {
                return 0;
            }
            Arrays.sort(boxTypes, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);

            int max = 0;
            for (int[] boxType : boxTypes) {
                if (truckSize >= boxType[0]) {
                    max += boxType[0] * boxType[1];

                    truckSize = truckSize - boxType[0];
                } else {
                    max += truckSize * boxType[1];
                    break;
                }
            }

            return max;
        }
    }
}
