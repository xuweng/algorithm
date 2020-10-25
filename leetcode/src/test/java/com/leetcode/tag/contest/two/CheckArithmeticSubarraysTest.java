package com.leetcode.tag.contest.two;

import org.junit.Test;

public class CheckArithmeticSubarraysTest {
    CheckArithmeticSubarrays.Solution solution = new CheckArithmeticSubarrays.Solution();

    @Test
    public void checkArithmeticSubarrays() {
        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0, 0, 2};
        int[] r = {2, 3, 5};
        solution.checkArithmeticSubarrays(nums, l, r);
    }

}