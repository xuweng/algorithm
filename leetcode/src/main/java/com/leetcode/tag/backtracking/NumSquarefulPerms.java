package com.leetcode.tag.backtracking;

import com.leetcode.tag.util.Square;

import java.util.*;

/**
 * 996. 正方形数组的数目
 */
public class NumSquarefulPerms {
  public int numSquarefulPerms(int[] A) {
    Arrays.sort(A);

    boolean[] used = new boolean[A.length];
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> stack = new LinkedList<>();

    backTrack(A, used, result, stack);

    return (int) result.stream().filter(this::isSquare).count();
  }

  private void backTrack(
          int[] array, boolean[] used, List<List<Integer>> result, Deque<Integer> stack) {
    if (stack.size() == array.length) {
      result.add(new ArrayList<>(stack));
      return;
    }
    for (int i = 0; i < array.length; i++) {
      if (used[i] || (i > 0 && array[i] == array[i - 1])) {
        continue;
      }
      used[i] = true;
      stack.push(array[i]);
      backTrack(array, used, result, stack);
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
