package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 枚举所有的可能，不满足条件的就干掉
 *
 * <p>枚举所有可能，不满足条件的干掉
 *
 * <p>枚举所有可能，不满足条件的干掉
 *
 * <p>枚举所有可能，不满足条件干掉
 *
 * <p>枚举所有可能，不满足条件干掉
 *
 * <p>搞懂5个示例
 *
 * <p>搞懂5个示例
 *
 * <p>搞懂5个示例
 *
 * <p>搞懂5个示例
 *
 * <p>搞懂5个示例
 *
 * <p>搞懂5个示例
 *
 * <p>842. 将数组拆分成斐波那契序列
 */
public class SplitIntoFibonacci {
  public List<Integer> splitIntoFibonacci(String S) {
    List<Integer> stack = new ArrayList<>();
    List<Integer> result = new ArrayList<>();

    backTrack(S, 0, stack, result);

    return result;
  }

  public void backTrack(String S, int start, List<Integer> stack, List<Integer> result) {
    // 越界统计
    if (start >= S.length() && isFibonacci(stack)) {
      result.addAll(new ArrayList<>(stack));
    }
    for (int i = start; i < S.length(); i++) {
      stack.add(Integer.valueOf(S.substring(start, i + 1)));
      backTrack(S, i + 1, stack, result);
      stack.remove(stack.size() - 1);
    }
  }

  private boolean isFibonacci(List<Integer> result) {
    int pre1 = result.get(0);
    int pre2 = result.get(1);

    for (int i = 2; i < result.size(); i++) {
      if (pre1 + pre2 != result.get(i)) {
        return false;
      }
      pre1 = pre2;
      pre2 = result.get(i);
    }

    return true;
  }
}
