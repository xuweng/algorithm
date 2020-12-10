package com.leetcode.tag.backtracking.one;

import java.util.*;

/**
 * 代码模板
 *
 * <p>代码模板
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>代码模板
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>这类题判断没有那么多
 *
 * <p>140. 单词拆分 II
 *
 * <p>句子中所有的单词都在词典中
 */
public class WordBreak {
  Map<Character, List<String>> map = new HashMap<>();
  List<String> temp = new ArrayList<>();
  List<String> result = new ArrayList<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    init(wordDict);

    re(s, 0, s.length() - 1);

    return result;
  }

  public void re(String s, int low, int high) {
    if (low > high) {
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < temp.size(); i++) {
        String s1 = temp.get(i);
        stringBuilder.append(s1);
        if (i != temp.size() - 1) {
          stringBuilder.append(" ");
        }
      }
      result.add(stringBuilder.toString());
      return;
    }

    List<String> list = map.get(s.charAt(low));
    if (list == null) {
      return;
    }
    for (String s1 : list) {
      if (low + s1.length() - 1 > high) {
        continue;
      }
      String s2 = s.substring(low, low + s1.length());
      if (s1.equals(s2)) {
        temp.add(s2);

        re(s, low + s1.length(), high);

        temp.remove(temp.size() - 1);
      }
    }
  }

  public void init(List<String> wordDict) {
    wordDict.forEach(
            s -> {
              List<String> list = map.getOrDefault(s.charAt(0), new ArrayList<>());
              list.add(s);
              map.put(s.charAt(0), list);
            });
  }

  /**
   * 作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/word-break-ii/solution/dan-ci-chai-fen-ii-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
      return wordBreak(s, wordDict, 0);
    }

    public List<String> wordBreak(String s, Set<String> wordDict, int start) {
      LinkedList<String> res = new LinkedList<>();
      if (start == s.length()) {
        res.add("");
      }
      for (int end = start + 1; end <= s.length(); end++) {
        if (wordDict.contains(s.substring(start, end))) {
          List<String> list = wordBreak(s, wordDict, end);
          for (String l : list) {
            res.add(s.substring(start, end) + ("".equals(l) ? "" : " ") + l);
          }
        }
      }
      return res;
    }
  }
}
