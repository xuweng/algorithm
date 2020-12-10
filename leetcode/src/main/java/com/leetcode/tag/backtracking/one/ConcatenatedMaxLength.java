package com.leetcode.tag.backtracking.one;

import java.util.HashSet;
import java.util.List;

/**
 * 1239. 串联字符串的最大长度
 */
public class ConcatenatedMaxLength {
  int maxLength;

  public int maxLength(List<String> arr) {
    backTrack(arr, "", 0);

    return maxLength;
  }

  public void backTrack(List<String> arr, String temp, int start) {
    maxLength = Math.max(maxLength, temp.length());

    for (int i = start; i < arr.size(); i++) {
      if (contains(temp, arr.get(i))) {
        continue;
      }
      backTrack(arr, temp + arr.get(i), i + 1);
    }
  }

  private boolean contains(String s, String s1) {
    HashSet<Character> hashSet = new HashSet<>();
    for (int i = 0; i < s1.length(); i++) {
      if (!hashSet.add(s1.charAt(i))) {
        return true;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      if (s1.contains(String.valueOf(s.charAt(i)))) {
        return true;
      }
    }
    return false;
  }
}
