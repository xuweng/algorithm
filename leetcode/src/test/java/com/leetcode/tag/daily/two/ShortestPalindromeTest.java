package com.leetcode.tag.daily.two;


import org.junit.Test;

public class ShortestPalindromeTest {
    ShortestPalindrome.Solution3 solution3 = new ShortestPalindrome.Solution3();

    @Test
    public void shortestPalindrome() {
        String s = "aacecaaa";
        System.out.println(solution3.shortestPalindrome(s));
    }
}