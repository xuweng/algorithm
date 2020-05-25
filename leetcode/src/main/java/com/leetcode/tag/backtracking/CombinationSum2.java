package com.leetcode.tag.backtracking;

import java.util.*;

/**
 * 40. 组合总和 II
 *
 * <p>看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>candidates 中的每个数字在每个组合中只能使用一次。
 */
public class CombinationSum2 {
  List<List<Integer>> result = new ArrayList<>();
  Stack<Integer> stack = new Stack<>();

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0) {
      return result;
    }
    Arrays.sort(candidates);

    backTrack(candidates, 0, 0, target);

    return result;
  }

  public void backTrack(int[] candidates, int select, int sum, int target) {
    if (sum > target) {
      return;
    }
    if (sum == target) {
      result.add(new ArrayList<>(stack));
      return;
    }
    int i = select;
    while (i < candidates.length) {
      stack.push(candidates[i]);
      // 需要一些剪枝
      backTrack(candidates, i + 1, candidates[i] + sum, target);
      stack.pop();
      // 挑选下一个分支
      int j = i + 1;
      while (j < candidates.length && candidates[i] == candidates[j]) {
        j++;
      }
      if (j >= candidates.length) {
        return;
      }
      i = j;
    }
  }

  /**
   * 作者：liweiwei1419
   * 链接：https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {

    /**
     * @param candidates 候选数组
     * @param len
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param residue    表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径
     * @param res
     */
    private void dfs(
            int[] candidates,
            int len,
            int begin,
            int residue,
            Deque<Integer> path,
            List<List<Integer>> res) {
      if (residue == 0) {
        res.add(new ArrayList<>(path));
        return;
      }
      for (int i = begin; i < len; i++) {
        // 大剪枝
        if (residue - candidates[i] < 0) {
          break;
        }

        // 小剪枝
        if (i > begin && candidates[i] == candidates[i - 1]) {
          continue;
        }

        path.addLast(candidates[i]);

        // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
        dfs(candidates, len, i + 1, residue - candidates[i], path, res);

        path.removeLast();
      }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      int len = candidates.length;
      List<List<Integer>> res = new ArrayList<>();
      if (len == 0) {
        return res;
      }

      // 先将数组排序，这一步很关键
      Arrays.sort(candidates);

      Deque<Integer> path = new ArrayDeque<>(len);
      dfs(candidates, len, 0, target, path, res);
      return res;
    }
  }
}
