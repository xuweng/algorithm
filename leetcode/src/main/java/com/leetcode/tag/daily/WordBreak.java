package com.leetcode.tag.daily;

import java.util.*;

/**
 * 先通过所有示例，再提交
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>139. 单词拆分
 */
public class WordBreak {
  Map<Character, List<String>> map;
  // 递归深度
  int reCount;

  public boolean wordBreak(String s, List<String> wordDict) {
    if (wordDict == null || wordDict.isEmpty()) {
      return s.isEmpty();
    }
    map = new HashMap<>();
    for (String str : wordDict) {
      char key = str.charAt(0);
      List<String> list = map.getOrDefault(key, new ArrayList<>());
      list.add(str);
      map.put(key, list);
    }

    return backTrack(s);
  }

  public boolean backTrack(String s) {
    System.out.println(++reCount);

    char key = s.charAt(0);
    if (!map.containsKey(key)) {
      return false;
    }
    List<String> list = map.get(key);

    // 候选集
    for (String str : list) {
      if (str.length() > s.length()) {
        continue;
      }
      String s1 = s.substring(0, str.length());
      if (!Objects.equals(s1, str)) {
        continue;
      }
      if (str.length() == s.length()) {
        return true;
      }
      if (backTrack(s.substring(str.length()))) {
        return true;
      }
    }
    return false;
  }

  /**
   * 方法一：动态规划
   *
   * <p>我们定义dp[i] 表示字符串 s 前 i 个字符组成的字符串s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词
   *
   * <p>最终答案:dp[s.length]
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      Set<String> wordDictSet = new HashSet(wordDict);
      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;
      for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
          if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
            dp[i] = true;
            break;
          }
        }
      }
      return dp[s.length()];
    }
  }
}
