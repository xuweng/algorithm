package com.leetcode.tag.backtracking;

import com.leetcode.tag.util.Square;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 996. 正方形数组的数目
 */
public class NumSquarefulPerms {
  public int numSquarefulPerms(int[] A) {
    Arrays.sort(A);

    boolean[] used = new boolean[A.length];
    Set<String> result = new HashSet<>();

    backTrack(A, used, result, "");

    return (int) result.stream().filter(this::isSquare).count();
  }

  private void backTrack(int[] array, boolean[] used, Set<String> result, String temp) {
    if (temp.length() == array.length) {
      result.add(temp);
      return;
    }
    for (int i = 0; i < array.length; i++) {
      // 是否重复分支
      boolean fen = (temp.isEmpty() && i > 0 && array[i] == array[i - 1]);
      if (used[i] || fen) {
        continue;
      }
      // 不会选择重复分支，但是第一个分支会选择重复数据,需要处理第一个分支
      used[i] = true;
      backTrack(array, used, result, temp + array[i]);
      used[i] = false;
    }
  }

  private boolean isSquare(String str) {
    int pre = 0;
    for (int i = 1; i < str.length(); i++) {
      if (!Square.isPerfectSquare(
              Integer.parseInt(String.valueOf(str.charAt(pre)))
                      + Integer.parseInt(String.valueOf(str.charAt(i))))) {
        return false;
      }
      pre = i;
    }

    return true;
  }
}
