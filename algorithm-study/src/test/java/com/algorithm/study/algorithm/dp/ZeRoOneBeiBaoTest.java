package com.algorithm.study.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class ZeRoOneBeiBaoTest {
    int[] v = {2, 1, 3, 2};//体积
    int[] p = {3, 2, 4, 2};//价值
    int n = v.length;//物品数量
    int vMax = 5;//最大容积

    @Test
    public void maxPRe() {
        Assert.assertEquals(7, ZeRoOneBeiBao.maxPRe(v, p, n - 1, vMax));
    }

    @Test
    public void maxPDpTest() {
        Assert.assertEquals(7, ZeRoOneBeiBao.maxPDp(v, p, n, vMax));
    }
}
