package com.leetcode.tag.daily.six;

import org.junit.jupiter.api.Test;

class MinCostClimbingStairsTest {
    MinCostClimbingStairs.Solution solution = new MinCostClimbingStairs.Solution();

    @Test
    void minCostClimbingStairs() {
        int[] cost = {1, 100, 1, 1, 1};

        solution.minCostClimbingStairs(cost);
    }
}