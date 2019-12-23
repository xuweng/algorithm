package com.algorithm.study.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class MinDistanseTest {
    @Test
    public void findMinDistanseReTest() {
        String s1 = "rad", s2 = "apple";
        int i = s1.length() - 1, j = s2.length() - 1;

        Assert.assertEquals(5, MinDistanse.findMinDistanseRe(s1, s2, i, j));
    }

    @Test
    public void findMinDistanseDpTest() {
        String s1 = "rad", s2 = "apple";
        Assert.assertEquals(5, MinDistanse.findMinDistanseDp(s1, s2));
    }
}
