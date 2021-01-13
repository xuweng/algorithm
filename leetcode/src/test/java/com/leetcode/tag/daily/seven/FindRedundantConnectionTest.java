package com.leetcode.tag.daily.seven;

import org.junit.jupiter.api.Test;

class FindRedundantConnectionTest {
    FindRedundantConnection.Solution1 solution1 = new FindRedundantConnection.Solution1();

    @Test
    void findRedundantConnection() {
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};

        solution1.findRedundantConnection(edges);
    }

}