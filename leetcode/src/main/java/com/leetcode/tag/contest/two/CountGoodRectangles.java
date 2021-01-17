package com.leetcode.tag.contest.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 5653. 可以形成最大正方形的矩形数目
 */
public class CountGoodRectangles {
    class Solution {
        public int countGoodRectangles(int[][] rectangles) {
            if (rectangles == null || rectangles.length == 0) {
                return 0;
            }
            int max = 0;
            int result = 0;
            List<Integer> list = new ArrayList<>();
            for (int[] rectangle : rectangles) {
                list.add(Math.min(rectangle[0], rectangle[1]));
            }
            for (Integer integer : list) {
                max = Math.max(max, integer);
            }
            for (Integer integer : list) {
                if (integer == max) {
                    result++;
                }
            }

            return result;
        }
    }
}
