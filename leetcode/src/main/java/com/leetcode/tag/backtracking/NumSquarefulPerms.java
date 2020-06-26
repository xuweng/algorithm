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
      // stack转为字符串
      String s = stack.stream().map(String::valueOf).collect(Collectors.joining(","));
      if (set.add(s)) {
        // 去重
        result.add(new ArrayList<>(stack));
      }
      return;
    }
    for (int i = 0; i < array.length; i++) {
      // 是否重复分支。分支是对root来说。一定要加上stack.isEmpty()这个条件。
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

  /**
   * 构造一张图，包含所有的边 i 到 j ，如果满足 A[i]+A[j] 是一个完全平方数
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/number-of-squareful-arrays/solution/zheng-fang-xing-shu-zu-de-shu-mu-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    Map<Integer, Integer> count;
    Map<Integer, List<Integer>> graph;

    public int numSquarefulPerms(int[] A) {
      int N = A.length;
      count = new HashMap<>();
      graph = new HashMap<>();

      // count.get(v) : 数组 A 中值为 v 的节点数量
      for (int x : A) {
        count.put(x, count.getOrDefault(x, 0) + 1);
      }

      // graph.get(v) : 在 A 中的值 w 满足 v + w 是完全平方数
      //                (ie., "vw" is an edge)
      for (int x : count.keySet()) {
        graph.put(x, new ArrayList<>());
      }

      // 构造图
      for (int x : count.keySet()) {
        for (int y : count.keySet()) {
          int r = (int) (Math.sqrt(x + y) + 0.5);
          if (r * r == x + y) {
            graph.get(x).add(y);
          }
        }
      }

      // 增加从 x 开始的可行路径数量
      int ans = 0;
      for (int x : count.keySet()) {
        ans += dfs(x, N - 1);
      }
      return ans;
    }

    public int dfs(int x, int todo) {
      count.put(x, count.get(x) - 1);
      int ans = 1;
      if (todo != 0) {
        ans = 0;
        for (int y : graph.get(x)) {
          if (count.get(y) != 0) {
            ans += dfs(y, todo - 1);
          }
        }
      }
      count.put(x, count.get(x) + 1);
      return ans;
    }
  }
}
