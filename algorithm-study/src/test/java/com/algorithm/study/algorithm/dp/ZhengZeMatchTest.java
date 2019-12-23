package com.algorithm.study.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class ZhengZeMatchTest {
    @Test
    public void isMatchTest() {
//        String s = "aa", p = "a";
//        String s = "aa", p = "a*";
//        String s = "ab", p = ".*";
//        String s = "aab", p = "c*a*b";
        String s = "mississippi", p = "mis*is*p*.";
        int sIndex = s.length() - 1, pIndex = p.length() - 1;

        Assert.assertFalse(ZhengZeMatch.isMatchRe(s, p, sIndex, pIndex));
    }
}
