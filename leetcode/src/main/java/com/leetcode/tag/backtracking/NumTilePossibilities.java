package com.leetcode.tag.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 1079. 活字印刷
 */
public class NumTilePossibilities {
  public int numTilePossibilities(String tiles) {
    if (tiles == null || tiles.length() == 0) {
      return 0;
    }
    Set<String> result = new HashSet<>();

    backTrack(tiles, tiles.length(), "", result);

    return result.size() - 1;
  }

  public void backTrack(String titles, int length, String temp, Set<String> result) {
    result.add(temp);
    if (titles.isEmpty() || temp.length() >= length) {
      return;
    }
    for (int i = 0; i < titles.length(); i++) {
      if (i >= 1 && titles.charAt(i) == titles.charAt(i - 1)) {
        continue;
      }
      backTrack(getString(titles, i), length, temp + titles.charAt(i), result);
    }
  }

  public String getString(String titles, int index) {
    if (titles.length() == 1) {
      return "";
    }
    if (index == 0) {
      return titles.substring(1);
    }
    if (index == titles.length() - 1) {
      return titles.substring(0, titles.length() - 1);
    }
    return titles.substring(0, index) + titles.substring(index + 1);
  }

  class Solution {
    int lastIdx = 0;
    int[] charIdx = new int[26];
    // 统计字符个数
    int[] charCounts;

    public int numTilePossibilities(String tiles) {
      charCounts = new int[26];
      int charCount = 0;
      for (int i = 0; i < tiles.length(); i++) {
        int idx = tiles.charAt(i) - 'A';
        if (charCounts[idx] == 0) {
          charIdx[charCount] = idx;
          charCount++;
        }
        charCounts[idx]++;
      }
      lastIdx = charCount - 1;
      int result = 0;
      for (int len = 1; len <= tiles.length(); len++) {
        result += possibilitiesWithLen(0, len);
      }
      return result;
    }

    /**
     * 递归树
     *
     * <p>一条路径走到底(最左分支),开始从底回溯
     *
     * @param curIdx
     * @param lenLeft
     * @return
     */
    int possibilitiesWithLen(int curIdx, int lenLeft) {
      // 当前字符个数
      int charNumb = charCounts[charIdx[curIdx]];
      if (curIdx == lastIdx) {
        return (charNumb >= lenLeft) ? 1 : 0;
      }
      if (charNumb > lenLeft) {
        charNumb = lenLeft;
      }
      int result = 0;
      for (int i = 0; i <= charNumb; i++) {
        // 当前字符选择完后到下一个分支
        result += (kOutOfN(i, lenLeft) * possibilitiesWithLen(curIdx + 1, lenLeft - i));
      }
      return result;
    }

    private int kOutOfN(int k, int n) {
      if (k == 0) {
        return 1;
      }
      int m = n - k;
      if (k > m) {
        k = m;
      }
      int p1 = 1;
      int p2 = 1;
      for (; k > 0; k--, n--) {
        p1 *= n;
        p2 *= k;
      }
      return p1 / p2;
    }
  }
}
