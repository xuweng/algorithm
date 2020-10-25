package com.leetcode.tag.contest.two;

import org.junit.Test;

public class MinimumEffortPathTest {
    MinimumEffortPath.Solution solution = new MinimumEffortPath.Solution();

    @Test
    public void minimumEffortPath() {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        solution.minimumEffortPath(heights);
    }

}