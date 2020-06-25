package com.leetcode.tag.daily;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordBreakTest {
  WordBreak wordBreak = new WordBreak();

  @Test
  public void test() {

    String s = "leetcode";
    List<String> wordDict = Arrays.asList("leet", "code");

    System.out.println(wordBreak.wordBreak(s, wordDict));
  }

  @Test
  public void test1() {

    String s = "cars";
    List<String> wordDict = Arrays.asList("car", "ca", "rs");

    System.out.println(wordBreak.wordBreak(s, wordDict));
  }
}
