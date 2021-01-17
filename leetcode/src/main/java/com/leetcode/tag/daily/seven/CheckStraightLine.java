package com.leetcode.tag.daily.seven;

/**
 * 1232. 缀点成线
 */
public class CheckStraightLine {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if (coordinates == null || coordinates.length == 0) {
                return false;
            }

            int k = coordinates[0][1] - coordinates[0][0];
            for (int[] coordinate : coordinates) {
                if (coordinate[1] - coordinate[0] != k) {
                    return false;
                }
            }

            return true;
        }
    }
}
