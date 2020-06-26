package com.leetcode.tag.backtracking;

import com.leetcode.tag.util.Square;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 996. 正方形数组的数目
 */
public class NumSquarefulPerms {
  public int numSquarefulPerms(int[] A) {
    Set<Integer> hashSet = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    for (int i : A) {
      hashSet.add(i);
      list.add(i);
    }
    // 只有一个重复数字.只有一个排列
    if (hashSet.size() == 1) {
      return isSquare(list) ? 1 : 0;
    }

    Arrays.sort(A);

    boolean[] used = new boolean[A.length];
    Set<String> set = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> stack = new LinkedList<>();

    backTrack(A, used, result, set, stack);

    return (int) result.stream().filter(this::isSquare).count();
  }

  private void backTrack(
          int[] array,
          boolean[] used,
          List<List<Integer>> result,
          Set<String> set,
          Deque<Integer> stack) {
    if (stack.size() == array.length) {
      String s = stack.stream().map(String::valueOf).collect(Collectors.joining(","));
      if (set.add(s)) {
        result.add(new ArrayList<>(stack));
      }
      return;
    }
    for (int i = 0; i < array.length; i++) {
      // 是否重复分支
      boolean fen = (stack.isEmpty() && i > 0 && array[i] == array[i - 1]);
      if (used[i] || fen) {
        continue;
      }
      // 不会选择重复分支，但是第一个分支会选择重复数据,需要处理第一个分支
      used[i] = true;
      stack.push(array[i]);
      backTrack(array, used, result, set, stack);
      used[i] = false;
      stack.pop();
    }
  }

  private boolean isSquare(List<Integer> list) {
    int pre = 0;
    for (int i = 1; i < list.size(); i++) {
      if (!Square.isPerfectSquare(list.get(pre) + list.get(i))) {
        return false;
      }
      pre = i;
    }

    return true;
  }
}
