package com.leetcode.tag.contest.two;

/**
 * 5655. 重新排列后的最大子矩阵
 */
public class LargestSubmatrix {
    class Solution {
        public int largestSubmatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return 0;
            }
            int max = 0;
            int size = 0;
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    if (anInt == 0) {
                        size = 0;
                    } else {
                        size++;
                    }
                }
            }
            return 0;
        }
    }
}
