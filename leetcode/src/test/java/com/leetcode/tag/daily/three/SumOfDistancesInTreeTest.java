package com.leetcode.tag.daily.three;

import org.junit.Test;

public class SumOfDistancesInTreeTest {
    SumOfDistancesInTree.Solution solution = new SumOfDistancesInTree.Solution();

    @Test
    public void sumOfDistancesInTreeTest() {
        int N = 3;
        int[][] a = {{0, 1}, {0, 2}};
        solution.sumOfDistancesInTree(N, a);
    }
}