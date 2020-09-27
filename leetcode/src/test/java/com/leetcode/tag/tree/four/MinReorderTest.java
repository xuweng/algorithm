package com.leetcode.tag.tree.four;

import org.junit.Test;

public class MinReorderTest {
    MinReorder.Solution solution = new MinReorder.Solution();

    @Test
    public void minReorderTest() {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};

        solution.minReorder(n, connections);
    }
}