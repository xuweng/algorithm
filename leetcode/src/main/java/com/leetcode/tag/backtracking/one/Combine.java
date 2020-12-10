package com.leetcode.tag.backtracking.one;

import java.util.*;

/**
 * 算法模板
 *
 * <p>算法模板
 *
 * <p>算法模板
 *
 * <p>算法模板
 *
 * <p>算法模板
 *
 * <p>一定要看优秀代码
 *
 * <p>一定要看优秀代码
 *
 * <p>一定要看优秀代码
 *
 * <p>一定要看优秀代码
 *
 * <p>不要自恋
 *
 * <p>不要自恋
 *
 * <p>不要自恋
 *
 * <p>不要自恋
 *
 * <p>不要自恋
 *
 * <p>一定要看优秀代码
 *
 * <p>一定要看优秀代码
 */
public class Combine {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    backTrack(n, 0, k, 1, deque, result);
    return result;
  }

  /**
   * 算法模板
   *
   * <p>递归参数统计
   *
   * <p>一条路径不能有重复
   *
   * @param n
   * @param k
   * @param start
   */
  public void backTrack(
          int n, int count, int k, int start, Deque<Integer> deque, List<List<Integer>> result) {
    if (count == k) {
      result.add(new ArrayList<>(deque));
      return;
    }

    // 候选集
    for (int i = start; i <= n; i++) {
      // 当前选择i
      deque.push(i);
      // 回溯。从i+1开始选择。
      backTrack(n, count + 1, k, i + 1, deque, result);
      deque.pop();
    }
  }

  /**
   * 方法一 : 回溯法
   *
   * <p>作者：LeetCode 链接：https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public void backtrack(int first, LinkedList<Integer> curr) {
      // if the combination is done
      if (curr.size() == k) {
        output.add(new LinkedList(curr));
      }

      for (int i = first; i < n + 1; ++i) {
        // add i into the current combination
        curr.add(i);
        // use next integers to complete the combination
        backtrack(i + 1, curr);
        // backtrack
        curr.removeLast();
      }
    }

    public List<List<Integer>> combine(int n, int k) {
      this.n = n;
      this.k = k;
      backtrack(1, new LinkedList<>());
      return output;
    }
  }

  /**
   * 方法二: 字典序 (二进制排序) 组合
   *
   * <p>主要思路是以字典序的顺序获得全部组合。
   *
   * <p>作者：LeetCode 链接：https://leetcode-cn.com/problems/combinations/solution/zu-he-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public List<List<Integer>> combine(int n, int k) {
      // init first combination
      LinkedList<Integer> nums = new LinkedList<>();
      for (int i = 1; i < k + 1; ++i) {
        nums.add(i);
      }
      // 将 n + 1添加为末尾元素，起到“哨兵”的作用
      nums.add(n + 1);

      List<List<Integer>> output = new ArrayList<>();
      int j = 0;
      while (j < k) {
        // add current combination
        output.add(new LinkedList(nums.subList(0, k)));
        // increase first nums[j] by one
        // if nums[j] + 1 != nums[j + 1]
        j = 0;
        while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1)) {
          nums.set(j, j++ + 1);
        }
        nums.set(j, nums.get(j) + 1);
      }
      return output;
    }
  }
}
