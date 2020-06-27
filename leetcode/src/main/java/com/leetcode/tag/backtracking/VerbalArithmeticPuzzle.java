package com.leetcode.tag.backtracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 经典题目
 *
 * <p>简单实用
 *
 * <p>十分钟
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>搞懂所有示例
 *
 * <p>1307. 口算难题
 */
public class VerbalArithmeticPuzzle {
  public boolean isSolvable(String[] words, String result) {
    Set<Character> set = new TreeSet<>();
    for (String word : words) {
      for (char c : word.toCharArray()) {
        set.add(c);
      }
    }
    for (char c : result.toCharArray()) {
      set.add(c);
    }
    StringBuilder stringBuilder = new StringBuilder();
    set.forEach(stringBuilder::append);

    return backTrack(stringBuilder.toString(), 0, words, result, new HashMap<>());
  }

  /**
   * 算法框架
   *
   * <p>算法框架
   *
   * <p>算法框架
   *
   * <p>算法框架
   *
   * <p>算法框架
   *
   * @param result
   * @return
   */
  public boolean backTrack(
          String word, int start, String[] words, String result, Map<Character, Integer> map) {
    if (start >= word.length()) {
      // 被解码成一个没有前导零的数字
      if (result.charAt(0) == '0') {
        return false;
      }
      int sum = 0;
      for (String s : words) {
        if (s.charAt(0) == '0') {
          return false;
        }
        sum += Integer.parseInt(s);
      }

      return sum == Integer.parseInt(result);
    }
    for (int i = 0; i <= 9; i++) {
      char c = word.charAt(start);
      if (map.containsKey(c) || map.containsValue(i)) {
        continue;
      }
      map.put(c, i);
      String[] newWords = new String[words.length];
      for (int i1 = 0; i1 < words.length; i1++) {
        String w = words[i1];
        newWords[i1] = w.replace(String.valueOf(c), String.valueOf(i));
      }
      String newResult = result.replace(String.valueOf(c), String.valueOf(i));
      if (backTrack(word, start + 1, newWords, newResult, map)) {
        // 搜索到一个答案就返回。不用继续搜索后面的分支。只需要一个答案。
        return true;
      }
      map.remove(c);
    }

    return false;
  }
}
