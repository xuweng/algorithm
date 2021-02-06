package com.leetcode.tag.dp.one.two.three;

import org.junit.jupiter.api.Test;

class FindNumberOfLIS1Test {
    FindNumberOfLIS1.Solution solution = new FindNumberOfLIS1.Solution();

    @Test
    void findNumberOfLIS() {
        //        int[] nums = {1, 3, 5, 4, 7};
        int[] nums = {2, 2, 2, 2, 2};

        solution.findNumberOfLIS(nums);
    }
}