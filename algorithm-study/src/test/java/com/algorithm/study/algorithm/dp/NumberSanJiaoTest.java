package com.algorithm.study.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class NumberSanJiaoTest {
    @Test
    public void maxSumReTest() {
        int[][] a = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int n = 5, i = 0, j = 0;

        Assert.assertEquals(30, NumberSanJiao.maxSumRe(a, n, i, j));
    }

    @Test
    public void maxSumDpTest() {
        int[][] a = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int n = 5;

        Assert.assertEquals(30, NumberSanJiao.maxSumDp(a, n));
    }
}
