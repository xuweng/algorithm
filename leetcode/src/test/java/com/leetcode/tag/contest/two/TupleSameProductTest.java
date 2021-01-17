package com.leetcode.tag.contest.two;

import org.junit.jupiter.api.Test;

class TupleSameProductTest {
    TupleSameProduct.Solution solution = new TupleSameProduct.Solution();

    @Test
    void tupleSameProduct() {
        int[] nums = {20, 10, 6, 24, 15, 5, 4, 30};

        solution.tupleSameProduct(nums);
    }

    @Test
    void solution4() {
        TupleSameProduct.Solution4 solution = new TupleSameProduct.Solution4();

        int[] nums = {2, 3, 4, 6, 8, 12};

        solution.tupleSameProduct(nums);
    }
}