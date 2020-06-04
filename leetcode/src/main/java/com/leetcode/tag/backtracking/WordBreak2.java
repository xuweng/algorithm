package com.leetcode.tag.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 不同解法
 *
 * <p>不同解法
 *
 * <p>不同解法
 *
 * <p>不同解法
 *
 * <p>不同解法
 *
 * <p>不同解法
 *
 * <p>不同解法
 *
 * <p>不同解法
 */
public class WordBreak2 {
  /**
   * 方法 1：暴力 算法
   *
   * <p>解决此题最简单的方法是使用回溯。为了找到解，我们检查字符串（s）的所有可能前缀是否在字典中，
   *
   * <p>如果在（比方说 s1 ），那么调用回溯函数并检查剩余部分的字符串。
   *
   * <p>如果剩余部分可以形成有效拆分，这个函数返回前缀 s1 ，并将回溯调用的剩余结果（即 s−s1）跟在 s1 的后面。否则，返回空列表。
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/word-break-ii/solution/dan-ci-chai-fen-ii-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
      return word_Break(s, wordDict, 0);
    }

    public List<String> word_Break(String s, Set<String> wordDict, int start) {
      LinkedList<String> res = new LinkedList<>();
      if (start == s.length()) {
        res.add("");
      }
      for (int end = start + 1; end <= s.length(); end++) {
        if (wordDict.contains(s.substring(start, end))) {
          List<String> list = word_Break(s, wordDict, end);
          for (String l : list) {
            res.add(s.substring(start, end) + ("".equals(l) ? "" : " ") + l);
          }
        }
      }
      return res;
    }
  }

  /**
   * 重复计算
   *
   * <p>回溯最讨厌重复计算
   *
   * <p>方法 2：记忆化回溯 算法
   *
   * <p>在之前的方法中，我们可以看出许多子问题的求解都是冗余的，也就是我们对于相同的子串调用了函数多次。
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/word-break-ii/solution/dan-ci-chai-fen-ii-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
      return word_Break(s, wordDict, 0);
    }

    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break(String s, Set<String> wordDict, int start) {
      if (map.containsKey(start)) {
        return map.get(start);
      }
      LinkedList<String> res = new LinkedList<>();
      if (start == s.length()) {
        res.add("");
      }
      for (int end = start + 1; end <= s.length(); end++) {
        if (wordDict.contains(s.substring(start, end))) {
          List<String> list = word_Break(s, wordDict, end);
          for (String l : list) {
            res.add(s.substring(start, end) + ("".equals(l) ? "" : " ") + l);
          }
        }
      }
      map.put(start, res);
      return res;
    }
  }
}
