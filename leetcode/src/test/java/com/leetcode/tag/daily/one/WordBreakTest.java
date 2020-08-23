package com.leetcode.tag.daily.one;

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

  @Test
  public void test2() {

    String s = "applepenapple";
    List<String> wordDict = Arrays.asList("apple", "pen");

    System.out.println(wordBreak.wordBreak(s, wordDict));
  }

  @Test
  public void test3() {

    String s = "catsandog";
    List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");

    System.out.println(wordBreak.wordBreak(s, wordDict));
  }

  /**
   * 递归树。递归树。递归树。递归树。递归树
   *
   * <p>大量重复计算
   *
   * <p>哪里重复?哪些字符串重复计算?
   *
   * <p>s重复字符太多.每个字符候选集都太多
   */
  @Test
  public void test4() {

    String s =
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                    + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                    + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    List<String> wordDict =
            Arrays.asList(
                    "a",
                    "aa",
                    "aaa",
                    "aaaa",
                    "aaaaa",
                    "aaaaaa",
                    "aaaaaaa",
                    "aaaaaaaa",
                    "aaaaaaaaa",
                    "aaaaaaaaaa");

    System.out.println(wordBreak.wordBreak(s, wordDict));
  }
}
