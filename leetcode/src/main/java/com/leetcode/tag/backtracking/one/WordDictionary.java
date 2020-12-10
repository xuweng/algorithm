package com.leetcode.tag.backtracking.one;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 */
public class WordDictionary {
  private StringBuilder stringBuilder;

  /** Initialize your data structure here. */
  public WordDictionary() {
    stringBuilder = new StringBuilder();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    stringBuilder.append(word);
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   */
  public boolean search(String word) {
    if (word == null || word.isEmpty()) {
      return stringBuilder.length() == 0;
    }
    if (!word.contains(".")) {
      return stringBuilder.toString().contains(word);
    }

    return match(stringBuilder.toString(), word);
  }

  /**
   * . 可以表示任何一个字母
   *
   * @param word
   * @param pattern
   * @return
   */
  public boolean match(String word, String pattern) {
    if (pattern.charAt(0) == '.') {
      // . 可以表示任何一个字母。只能表示一个字母？不能重复表示不同字母？
      return match(word, pattern.substring(1)) || match(word.substring(1), pattern.substring(1));
    }
    if (word.charAt(0) == pattern.charAt(0)) {
      return match(word.substring(1), pattern.substring(1));
    } else {
      return match(word.substring(1), pattern);
    }
  }
}

/**
 * Your WordDictionary object will be instantiated and called as such: WordDictionary obj = new
 * WordDictionary(); obj.addWord(word); boolean param_2 = obj.search(word);
 */
