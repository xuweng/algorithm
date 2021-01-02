package com.leetcode.tag.daily.six;

import org.junit.jupiter.api.Test;

class MaxSlidingWindowTest {
    MaxSlidingWindow.Solution4 solution4 = new MaxSlidingWindow.Solution4();

    @Test
    void maxSlidingWindow() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        solution4.maxSlidingWindow(nums, k);
    }
}