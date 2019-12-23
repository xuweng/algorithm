package com.algorithm.study.algorithm.string;

import org.junit.Assert;
import org.junit.Test;

public class KmpTest {
    @Test
    public void baoLiTest() {
        String s = "BBC ABCDAB ABCDABCDABDE", p = "ABCDABD";

        Assert.assertEquals(15, Kmp.baoLi(s, p));

    }
}
