package com.leetcode.tag.binarysearch.one;

import org.junit.Test;

public class Search2Test {
    Search2.Solution solution = new Search2.Solution();

    @Test
    public void search() {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int target = 5;

        solution.search(arr, target);
    }
}