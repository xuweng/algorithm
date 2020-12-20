package com.leetcode.tag.dp.three;

import org.junit.jupiter.api.Test;

class ChangeTest {
    Change.Solution solution = new Change.Solution();

    @Test
    void change() {
        int amount = 5;
        int[] coins = {1, 2, 5};

        solution.change(amount, coins);
    }
}