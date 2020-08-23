package com.leetcode.tag.daily.one;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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
     * 关键:在词典中搜索子串
     *
     * <p>定义 dp[i] 表示考虑前 i 个字符最少的未识别的字符数量，从前往后计算 dp 值。
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

  /**
   * 方法二：字符串哈希
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/re-space-lcci/solution/hui-fu-kong-ge-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    static final long P = Integer.MAX_VALUE;
    static final long BASE = 41;

    /**
     * 思路和算法
     *
     * <p>我们使用字典树的目的是查找某一个串 s 是否在一个串的集合 S 当中，并且当我们知道s 是否在 S 中之后，
     *
     * <p>可以快速的知道在 s 后添加某一个新的字母得到的新串 s'是否在 S 中，
     *
     * <p>这个转移的过程是 O(1) 的。这是我们采用字典树而放弃使用 HashMap 类容器的一个理由，
     *
     * <p>这些容器不能实现 s 到 s' 的 O(1)转移，但字典树可以。
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
      Set<Long> hashValues =
              Arrays.stream(dictionary).map(this::getHash).collect(Collectors.toSet());

      int[] f = new int[sentence.length() + 1];
      Arrays.fill(f, sentence.length());

      f[0] = 0;
      for (int i = 1; i <= sentence.length(); ++i) {
        // 默认赋值
        f[i] = f[i - 1] + 1;
        long hashValue = 0;
        // 在词典中搜索子串
        for (int j = i; j >= 1; --j) {
          int t = sentence.charAt(j - 1) - 'a' + 1;
          hashValue = (hashValue * BASE + t) % P;
          if (hashValues.contains(hashValue)) {
            // 子串在词典中存在
            f[i] = Math.min(f[i], f[j - 1]);
          }
        }
      }

      return f[sentence.length()];
    }

    public long getHash(String s) {
      long hashValue = 0;
      for (int i = s.length() - 1; i >= 0; --i) {
        hashValue = (hashValue * BASE + s.charAt(i) - 'a' + 1) % P;
      }
      return hashValue;
    }
  }
}
