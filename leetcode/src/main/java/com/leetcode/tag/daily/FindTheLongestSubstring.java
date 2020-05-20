package com.leetcode.tag.daily;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * 定义状态.
 *
 * <p>前i个?以第i个结尾?两个定义都试一下
 *
 * <p>状态方程
 *
 * <p>第一个:f(0)=0,f(1)=0,f(2)=2;f(1)与f(2)能推导f(3)?
 *
 * <p>1371. 每个元音包含偶数次的最长子字符串
 */
public class FindTheLongestSubstring {
  /**
   * 暴力法
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
}
