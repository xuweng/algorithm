package com.algorithm.study.algorithm.stack;

import org.junit.Assert;
import org.junit.Test;

public class KuoHaoTests {
    @Test
    public void piPeiTest() {
        String[] str = {"{[]()[{}]}", "[{()}([])]"};
        for (String s : str) {
            Assert.assertTrue(KuoHao.piPei(s));
        }
    }
}
