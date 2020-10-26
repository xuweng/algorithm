package com.leetcode.tag.daily.four;

import org.junit.Test;

public class SmallerNumbersThanCurrentTest {
    SmallerNumbersThanCurrent.Solution solution = new SmallerNumbersThanCurrent.Solution();

    @Test
    public void smallerNumbersThanCurrentTest() {
        int[] nums = {8, 1, 2, 2, 3};
        solution.smallerNumbersThanCurrent(nums);
    }
}