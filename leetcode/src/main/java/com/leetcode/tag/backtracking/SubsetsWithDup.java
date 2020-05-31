package com.leetcode.tag.backtracking;

import java.util.*;

/**
 * 十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>90. 子集 II
 *
 * <p>说明：解集不能包含重复的子集。
 */
public class SubsetsWithDup {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Deque<Integer> deque = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> levels = new ArrayList<>();

    backTrack(nums, 0, 0, deque, levels, result);

    return result;
  }

  /**
   * 每条路径可以有重复
   *
   * <p>分支不能有重复。每层不能有重复。
   *
   * <p>不是每层不能有重复。是每个结点的分支不能有重复。
   *
   * @param nums
   * @param begin
   * @param deque
   * @param result
   */
  public void backTrack(
          int[] nums,
          int count,
          int begin,
          Deque<Integer> deque,
          List<List<Integer>> levels,
          List<List<Integer>> result) {

    if (count == levels.size()) {
      levels.add(new ArrayList<>());
    }

    // 越界也要计算一个结果
    result.add(new ArrayList<>(deque));
    // 越界不用进入循环
    for (int i = begin; i < nums.length; i++) {
      // 如何剪枝?如何剪枝?如何剪枝?如何剪枝?
      if (count != 0 && levels.get(count).contains(nums[i])) {
        continue;
      }
      deque.push(nums[i]);
      levels.get(count).add(nums[i]);
      backTrack(nums, count + 1, i + 1, deque, levels, result);
      // 以下部分都属于回溯
      deque.pop();
    }
  }

  /**
   * 作者：windliang
   * 链接：https://leetcode-cn.com/problems/subsets-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-19/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class S {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      // 排序
      Arrays.sort(nums);
      getAns(nums, 0, new ArrayList<>(), ans);
      return ans;
    }

    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
      ans.add(new ArrayList<>(temp));
      // 候选集
      // 分支
      for (int i = start; i < nums.length; i++) {
        // 和上个数字相等就跳过
        // 跳过i这个分支
        if (i > start && nums[i] == nums[i - 1]) {
          continue;
        }
        temp.add(nums[i]);
        getAns(nums, i + 1, temp, ans);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
