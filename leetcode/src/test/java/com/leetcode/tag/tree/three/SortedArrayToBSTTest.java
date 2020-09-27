package com.leetcode.tag.tree.three;

import org.junit.Test;

public class SortedArrayToBSTTest {
    SortedArrayToBST.Solution solution = new SortedArrayToBST.Solution();

    @Test
    public void sortedArrayToBSTTest() {
        int[] nums = {-10, -3, 0, 5, 9};
        solution.sortedArrayToBST(nums);
    }
}