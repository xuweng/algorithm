package com.leetcode.tag.tree.two;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MinTimeTest {
    MinTime.Solution solution = new MinTime.Solution();

    @Test
    public void minTimeTest() {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}};
        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);

        solution.minTime(n, edges, hasApple);
    }
}