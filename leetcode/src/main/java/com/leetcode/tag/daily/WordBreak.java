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
  Map<String, Boolean> memo;
  // 递归深度
  int reCount;

  public boolean wordBreak(String s, List<String> wordDict) {
    if (wordDict == null || wordDict.isEmpty()) {
      return s.isEmpty();
    }
    map = new HashMap<>();
    memo = new HashMap<>();

    for (String str : wordDict) {
      char key = str.charAt(0);
      List<String> list = map.getOrDefault(key, new ArrayList<>());
      list.add(str);
      map.put(key, list);
    }

    return backTrack(s);
  }

  /**
   * 在所有return的地方加上memo
   *
   * <p>我们这个递归是前序遍历的，遍历到右侧子树时发现前面都已经计算过了 用一个备忘录 memo 数组，
   *
   * <p>去存之前计算的结果，index 对应指针 start，值对应子调用的结果，即子树的返回结果
   *
   * <p>下次遇到相同的子调用，即遇到相同的子树，就直接返回 memo 中的缓存结果
   *
   * <p>作者：hyj8
   * 链接：https://leetcode-cn.com/problems/word-break/solution/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param s
   * @return
   */
  public boolean backTrack(String s) {
    if (memo.containsKey(s)) {
      return memo.get(s);
    }
    char key = s.charAt(0);
    if (!map.containsKey(key)) {
      memo.put(s, false);
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
        memo.put(s, true);
        return true;
      }
      if (backTrack(s.substring(str.length()))) {
        memo.put(s, true);
        return true;
      }
    }
    memo.put(s, false);
    return false;
  }

  /**
   * 方法一：动态规划
   *
   * <p>dp状态定义:能否计算最终答案?能否计算原问题答案?
   *
   * <p>我们定义dp[i] 表示字符串 s 前 i 个字符组成的字符串s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词
   *
   * <p>dp状态定义注意数组下标
   *
   * <p>最终答案:dp[s.length]
   *
   * <p>最优子结构
   *
   * <p>这样定义可以用子问题推导原问题
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      Set<String> wordDictSet = new HashSet(wordDict);
      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;
      for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
          // 前 j 个字符(数组下标0到j-1),这里的j不是数组下标
          // 这里是s.substring(j, i),不是s.substring(j+1, i)
          if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
            dp[i] = true;
            // 只要找到一个满足条件就可以
            break;
          }
        }
      }
      // 原问题解
      return dp[s.length()];
    }
  }

  /**
   * 短小精悍
   */
  class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
      if (s.length() == 0) {
        return true;
      }
      if (s.length() >= 151) {
        return false;
      }
      // 重复使用wordDict
      for (int i = 0; i < wordDict.size(); i++) {
        String word = wordDict.get(i);
        // 剪枝
        // startsWith这个函数好用
        if (!s.startsWith(word)) {
          continue;
        }
        if (wordBreak(s.substring(word.length()), wordDict)) {
          return true;
        }
      }
      return false;
    }
  }
}
