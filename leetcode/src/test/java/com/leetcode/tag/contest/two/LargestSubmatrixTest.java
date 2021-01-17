package com.leetcode.tag.contest.two;

import org.junit.jupiter.api.Test;

class LargestSubmatrixTest {
    LargestSubmatrix.Solution1 solution1 = new LargestSubmatrix.Solution1();

    @Test
    void largestSubmatrix() {
        int[][] matrix = {{0, 0, 1}, {1, 1, 1}, {1, 0, 1}};

        solution1.largestSubmatrix(matrix);
    }
}