package com.leetcode.tag.daily.one;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 没学过就是不会
 *
 * <p>没学过就是不会
 *
 * <p>这类题本质:满足条件的子串、子序列
 *
 * <p>子串、子序列
 *
 * <p>连续、不连续
 *
 * <p>连续:f(n-1)----------->f(n)
 *
 * <p>不连续:f(1)、f(2)、f(3)..........f(n-1)------------>f(n)
 *
 * <p>定义状态.
 *
 * <p>前i个?以第i个结尾?两个定义都试一下
 *
 * <p>状态方程
 *
 * <p>第一个:f(0)=0,f(1)=0,f(2)=2;f(1)与f(2)能推导f(3)?
 *
 * <p>还需要哪些信息?
 *
 * <p>1371. 每个元音包含偶数次的最长子字符串
 */
public class FindTheLongestSubstring {
  /**
   * 我们先来考虑暴力方法怎么做。最直观的方法无非就是枚举所有子串，
   *
   * <p>遍历子串中的所有字符，统计元音字母出现的个数。
   *
   * <p>如果符合条件，我们就更新答案，但这样肯定会因为超时而无法通过所有测试用例。
   *
   * <p>暴力法
   *
   * <p>超出时间限制
   *
   * <p>优化暴力法
   *
   * <p>时间复杂度
   *
   * @param s
   * @return
   */
  public int findTheLongestSubstring(String s) {
    char[] yuan = {'a', 'e', 'i', 'o', 'u'};
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        Map<Character, Integer> map = count(s, i, j);
        if (valide(yuan, map)) {
          count = Math.max(count, j - i + 1);
        }
      }
    }

    return count;
  }

  public boolean valide(char[] yuan, Map<Character, Integer> map) {
    for (char c : yuan) {
      int count = map.getOrDefault(c, 0);
      if (count % 2 != 0) {
        return false;
      }
    }
    return true;
  }

  public Map<Character, Integer> count(String s, int low, int high) {
    Map<Character, Integer> map = new TreeMap<>();
    IntStream.rangeClosed(low, high)
            .forEach(i -> map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1));
    return map;
  }

  /**
   * 状态压缩＋哈希表。类似的题出现好几次了。 如1124。 状态压缩后，哈希表的用处是求最长的连续子串，满足子数组的和为k。
   *
   * <p>此题k为0， 1124题k为1.
   *
   * <p>遇到奇偶个数校验，想到XOR 遇到有限的参数（小于20个）表状态， 想到状态压缩 （bitmask）
   *
   * <p>遇到求最长的连续子串使得和为k（maximum continuous
   *
   * <p>subarray(substring) with sum equal to k）想到 前缀和 加哈希表记录第一次出现某一状态的位置。
   *
   * <p>这道题变相的考了用位运算解决了奇偶性以及前缀法，很新颖
   *
   * <p>方法一：前缀和 + 状态压缩
   */
  class Solution {
    /**
     * 其实每个子串对应着一个区间，那么有什么方法可以在不重复遍历子串的前提下，
     *
     * <p>快速求出这个区间里元音字母出现的次数呢？答案就是前缀和，
     *
     * <p>对于一个区间，我们可以用两个前缀和的差值，得到其中某个字母的出现次数。
     *
     * <p>我们对每个元音字母维护一个前缀和，定义 pre[i][k] 表示在字符串前 i 个字符中，第 k 个元音字母一共出现的次数。
     *
     * <p>假设我们需要求出[l,r] 这个区间的子串是否满足条件，那么我们可以用 pre[r][k]−pre[l−1][k]
     *
     * <p>作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/solution/mei-ge-yuan-yin-bao-han-ou-shu-ci-de-zui-chang-z-2/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
      int[] pos = new int[1 << 5];
      Arrays.fill(pos, -1);
      pos[0] = 0;

      int n = s.length();
      int ans = 0, status = 0;
      for (int i = 0; i < n; i++) {
        char ch = s.charAt(i);
        if (ch == 'a') {
          status ^= (1 << 0);
        } else if (ch == 'e') {
          status ^= (1 << 1);
        } else if (ch == 'i') {
          status ^= (1 << 2);
        } else if (ch == 'o') {
          status ^= (1 << 3);
        } else if (ch == 'u') {
          status ^= (1 << 4);
        }
        if (pos[status] >= 0) {
          ans = Math.max(ans, i + 1 - pos[status]);
        } else {
          pos[status] = i + 1;
        }
      }
      return ans;
    }
  }
}
