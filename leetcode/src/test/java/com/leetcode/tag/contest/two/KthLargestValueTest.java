package com.leetcode.tag.contest.two;

import org.junit.jupiter.api.Test;

class KthLargestValueTest {
    KthLargestValue.Solution1 solution1 = new KthLargestValue.Solution1();

    @Test
    void test() {
        int[][] matrix = {{5, 2}, {1, 6}};
        int k = 3;
        solution1.kthLargestValue(matrix, k);
    }
}