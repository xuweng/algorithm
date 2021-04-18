package com.leetcode.tag.must1.two;

import org.junit.jupiter.api.Test;

class RemoveElementTest {
    RemoveElement.Solution solution = new RemoveElement.Solution();

    @Test
    void test() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        solution.removeElement(nums, val);
    }
}