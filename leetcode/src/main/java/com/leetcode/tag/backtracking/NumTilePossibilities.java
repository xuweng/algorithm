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
    return titles.substring(0, index) + titles.substring(index);
  }
}
