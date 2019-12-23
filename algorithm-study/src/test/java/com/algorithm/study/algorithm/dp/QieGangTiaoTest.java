package com.algorithm.study.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class QieGangTiaoTest {
    @Test
    public void qieGangTiaoReTest() {
//        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] p = {1, 5, 8, 9};
        int n = p.length;

        Assert.assertEquals(10, QieGangTiao.qieGangTiaoRe(p, n));
    }

    @Test
    public void qieGangTiaoReMemoTest() {
//        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] p = {1, 5, 8, 9};
        int n = p.length;

        Assert.assertEquals(10, QieGangTiao.qieGangTiaoReMemo(p, n));
    }

    @Test
    public void qieGangTiaoDpTest() {
//        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int[] p = {1, 5, 8, 9};

        Assert.assertEquals(10, QieGangTiao.qieGangTiaoDp(p));
    }
}
