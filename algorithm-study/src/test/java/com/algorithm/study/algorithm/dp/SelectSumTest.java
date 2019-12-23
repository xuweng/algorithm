package com.algorithm.study.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class SelectSumTest {
    @Test
    public void selectSumReTest() {
        int[] a = {3, 34, 4, 12, 5, 2};
        int i = a.length - 1;
        int s = 9;
        Assert.assertTrue(SelectSum.selectSumRe(a, i, s));
    }

    @Test
    public void selectSumDp() {
        int[] a = {3, 34, 4, 12, 5, 2};
        int s = 9;
        Assert.assertTrue(SelectSum.selectSumDp(a, s));
    }
}
