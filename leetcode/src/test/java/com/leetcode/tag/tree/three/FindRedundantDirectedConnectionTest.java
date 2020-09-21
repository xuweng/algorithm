package com.leetcode.tag.tree.three;

import org.junit.Test;

public class FindRedundantDirectedConnectionTest {
    FindRedundantDirectedConnection.Solution solution = new FindRedundantDirectedConnection.Solution();

    @Test
    public void findRedundantDirectedConnectionTest() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};

        solution.findRedundantDirectedConnection(edges);
    }
}