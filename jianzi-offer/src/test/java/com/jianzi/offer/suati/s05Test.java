package com.jianzi.offer.suati;

import org.junit.Test;

public class s05Test {
    static String s = "We are happy.";
    static s05 s05 = new s05();

    @Test
    public void replaceSpaceTest() {
        System.out.println(s05.replaceSpace(s));
    }
}
