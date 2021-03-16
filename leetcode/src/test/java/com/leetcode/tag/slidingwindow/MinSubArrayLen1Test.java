package com.leetcode.tag.slidingwindow;

import org.junit.jupiter.api.Test;

class MinSubArrayLen1Test {
    MinSubArrayLen1.Solution solution = new MinSubArrayLen1.Solution();

    @Test
    void test() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        int i = solution.minSubArrayLen(target, nums);

        System.out.println(i);
    }
}