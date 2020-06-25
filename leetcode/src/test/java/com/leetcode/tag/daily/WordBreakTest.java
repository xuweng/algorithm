package com.leetcode.tag.daily;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordBreakTest {
  @Test
  public void test() {
    WordBreak wordBreak = new WordBreak();

    String s = "leetcode";
    List<String> wordDict = Arrays.asList("leet", "code");

    System.out.println(wordBreak.wordBreak(s, wordDict));
  }
}
