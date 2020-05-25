package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 1239. 串联字符串的最大长度
 */
public class ConcatenatedMaxLength {
  List<String> result = new ArrayList<>();

  public int maxLength(List<String> arr) {
    backTrack(arr, "", 0);

    int maxLength = 0;
    for (String s : result) {
      maxLength = Math.max(maxLength, s.length());
    }
    return maxLength;
  }

  public void backTrack(List<String> arr, String temp, int start) {
    result.add(temp);

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
