package com.algorithm.study.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class LISTest {
    int[] a = {2, 7, 1, 5, 6, 4, 3, 8, 9};
//    int[] a = {3, 1, 2, 6, 4, 5, 10, 7};

    @Test
    public void lisReTest() {
        Assert.assertEquals(5, LIS.lisRe(a, a.length - 1));
    }

    @Test
    public void lisReMemoTest() {
        Assert.assertEquals(5, LIS.lisReMemo(a, a.length - 1));
    }

    @Test
    public void lisDpTest() {
        Assert.assertEquals(5, LIS.lisDp(a));
    }

    @Test
    public void lisBinaryTest() {
        Assert.assertEquals(5, LIS.lisBinary(a));
    }
}
