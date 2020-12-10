package com.leetcode.tag.backtracking.one;

import java.util.*;

/**
 * 47. 全排列 II
 */
public class PermuteUnique {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    Arrays.sort(nums);

    backTrack(nums, 0, nums.length, deque, result);

    return result;
  }

  public void backTrack(
          int[] nums, int count, int n, Deque<Integer> deque, List<List<Integer>> result) {
    if (count >= n) {
      result.add(new ArrayList<>(deque));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (i >= 1 && nums[i] == nums[i - 1]) {
        continue;
      }
      deque.push(nums[i]);
      backTrack(delete(nums, i), count + 1, n, deque, result);
      deque.pop();
    }
  }

  public int[] delete(int[] nums, int index) {
    int[] result = new int[nums.length - 1];
    if (nums.length == 1) {
      return result;
    }
    if (index == nums.length - 1) {
      System.arraycopy(nums, 0, result, 0, nums.length - 1);
      return result;
    }
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i == index) {
        continue;
      }
      result[j++] = nums[i];
    }
    return result;
  }

  /**
   * 作者：liweiwei1419
   * 链接：https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
      int len = nums.length;
      List<List<Integer>> res = new ArrayList<>();
      if (len == 0) {
        return res;
      }

      // 排序（升序或者降序都可以），排序是剪枝的前提
      Arrays.sort(nums);

      // 标记每条路径的选择
      boolean[] used = new boolean[len];
      // 使用 Deque 是 Java 官方 Stack 类的建议
      Deque<Integer> path = new ArrayDeque<>(len);
      dfs(nums, len, 0, used, path, res);
      return res;
    }

    private void dfs(
            int[] nums,
            int len,
            int depth,
            boolean[] used,
            Deque<Integer> path,
            List<List<Integer>> res) {
      if (depth == len) {
        res.add(new ArrayList<>(path));
        return;
      }

      // 计算顺序.所有分支从左到右计算。全部计算完一个分支，再继续计算另外一个分支
      for (int i = 0; i < len; ++i) {
        if (used[i]) {
          continue;
        }

        // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
        // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
        if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
          continue;
        }

        path.addLast(nums[i]);
        used[i] = true;

        dfs(nums, len, depth + 1, used, path, res);
        // 回溯部分的代码，和 dfs 之前的代码是对称的
        used[i] = false;
        path.removeLast();
      }
    }
  }
}
