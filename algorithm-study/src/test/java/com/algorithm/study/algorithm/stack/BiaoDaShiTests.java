package com.algorithm.study.algorithm.stack;

import org.junit.Test;

public class BiaoDaShiTests {
    @Test
    public void calcualteTest() {
        String exp = "3+5*8-6";

        System.out.println(BiaoDaShi.calcualte(exp));
    }
}
