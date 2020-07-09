package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * dp考验推理能力
 *
 * <p>推理
 *
 * <p>推理
 *
 * <p>推理
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>面试题 17.13. 恢复空格
 */
public class ReSpaceLcci {
  /**
   * 方法一：Trie + 动态规划
   */
  class Solution {
    /**
     * 定义 dp[i] 表示考虑前 i 个字符最少的未识别的字符数量，从前往后计算 dp 值。
     *
     * <p>考虑转移方程，每次转移的时候我们考虑第 j 个到第 i 个字符组成的子串sentence[j−1⋯i−1]
     *
     * <p>（注意字符串下标从 0 开始）是否能在词典中找到，如果能找到的话按照定义转移方程即为
     *
     * <p>dp[i]=min(dp[i],dp[j−1])
     *
     * <p>否则没有找到的话我们可以复用dp[i−1] 的状态再加上当前未被识别的第 i 个字符，因此此时 dp 值为
     *
     * <p>dp[i]=dp[i−1]+1
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
      int n = sentence.length();

      Trie root = new Trie();
      for (String word : dictionary) {
        root.insert(word);
      }

      int[] dp = new int[n + 1];
      Arrays.fill(dp, Integer.MAX_VALUE);
      dp[0] = 0;
      for (int i = 1; i <= n; ++i) {
        dp[i] = dp[i - 1] + 1;

        Trie curPos = root;
        for (int j = i; j >= 1; --j) {
          int t = sentence.charAt(j - 1) - 'a';
          if (curPos.next[t] == null) {
            break;
          } else if (curPos.next[t].isEnd) {
            dp[i] = Math.min(dp[i], dp[j - 1]);
          }
          if (dp[i] == 0) {
            break;
          }
          curPos = curPos.next[t];
        }
      }
      return dp[n];
    }
  }

  class Trie {
    public Trie[] next;
    public boolean isEnd;

    public Trie() {
      next = new Trie[26];
      isEnd = false;
    }

    public void insert(String s) {
      Trie curPos = this;

      for (int i = s.length() - 1; i >= 0; --i) {
        int t = s.charAt(i) - 'a';
        if (curPos.next[t] == null) {
          curPos.next[t] = new Trie();
        }
        curPos = curPos.next[t];
      }
      curPos.isEnd = true;
    }
  }
}
