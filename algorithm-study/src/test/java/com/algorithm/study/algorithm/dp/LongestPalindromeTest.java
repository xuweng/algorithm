package com.algorithm.study.algorithm.dp;

import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromeTest {
    @Test
    public void longestPalindromeTest() {
        String s = "babad";
//        String s = "bb";
//        String s = "cbbd";
        int i = 0, j = s.length() - 1;

        Assert.assertEquals(3, LongestPalindrome.longestPalindromeRe(s, i, j));
    }
}
