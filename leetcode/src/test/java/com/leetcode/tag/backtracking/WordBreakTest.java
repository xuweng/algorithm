package com.leetcode.tag.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordBreakTest {
  @Test
  public void replaceSpaceTest() {
    WordBreak wordBreak = new WordBreak();

    String s = "catsanddog";
    List<String> wordDict = new ArrayList<>();
    wordDict.add("cat");
    wordDict.add("cats");
    wordDict.add("and");
    wordDict.add("sand");
    wordDict.add("dog");

    wordBreak.wordBreak(s, wordDict);
  }
}
