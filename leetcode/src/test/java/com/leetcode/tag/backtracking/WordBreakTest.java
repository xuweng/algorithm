package com.leetcode.tag.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WordBreakTest {
  @Test
  public void replaceSpaceTest() {
    WordBreak wordBreak = new WordBreak();

    //    String s = "catsanddog";
    //    List<String> wordDict = new ArrayList<>();
    //    wordDict.add("cat");
    //    wordDict.add("cats");
    //    wordDict.add("and");
    //    wordDict.add("sand");
    //    wordDict.add("dog");

    String s = "pineapplepenapple";
    List<String> wordDict = new ArrayList<>();
    wordDict.add("apple");
    wordDict.add("pen");
    wordDict.add("applepen");
    wordDict.add("pine");
    wordDict.add("pineapple");

    wordBreak.wordBreak(s, wordDict);
  }
}
