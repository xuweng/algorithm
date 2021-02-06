package com.leetcode.tag.dp.one.two.three;

import org.junit.jupiter.api.Test;

class FindMaxForm2Test {
    FindMaxForm2.Solution solution = new FindMaxForm2.Solution();

    @Test
    public void findMaxForm() {
        String[] strs = {"10", "0", "1"};
        int m = 1;
        int n = 1;

        solution.findMaxForm(strs, m, n);
    }
}