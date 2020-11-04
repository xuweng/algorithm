package com.leetcode.tag.binarysearch.one;

import org.junit.Test;

public class MissingNumberTest {
    MissingNumber.Solution solution = new MissingNumber.Solution();

    @Test
    public void missingNumber() {
        int[] nums = {0, 1, 3};

        solution.missingNumber(nums);
    }
}