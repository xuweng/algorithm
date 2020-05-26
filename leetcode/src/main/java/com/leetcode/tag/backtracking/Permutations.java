package com.leetcode.tag.backtracking;

import java.util.*;

/**
 * 46. 全排列
 */
public class Permutations {
  /**
   * 老办法
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> permute(int[] nums) {
    return re(nums, nums.length - 1);
  }

  public List<List<Integer>> re(int[] nums, int n) {
    if (n <= 0) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> list = new ArrayList<>();
      list.add(nums[0]);
      result.add(list);

      return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<List<Integer>> lists = re(nums, n - 1);
    if (lists == null) {
      return result;
    }

    for (List<Integer> list : lists) {
      List<Integer> list2 = new ArrayList<>();
      list2.add(nums[n]);
      list2.addAll(list);
      result.add(list2);
      for (int i = 0; i < list.size(); i++) {
        List<Integer> list1 = new ArrayList<>(list.subList(0, i + 1));
        list1.add(nums[n]);
        if (i != lists.size() - 1) {
          list1.addAll(list.subList(i + 1, list.size()));
        }

        result.add(list1);
      }
    }

    return result;
  }

  List<List<Integer>> result = new ArrayList<>();
  Stack<Integer> stack = new Stack<>();

  public List<List<Integer>> permute2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    backTrack(nums);
    return result;
  }

  public void backTrack(int[] nums) {
    if (nums.length == 0) {
      result.add(new ArrayList<>(stack));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      stack.push(nums[i]);
      backTrack(delete(nums, i));
      stack.pop();
    }
  }

  public int[] delete(int[] nums, int index) {
    int[] array = new int[nums.length - 1];
    if (index == nums.length - 1) {
      if (nums.length >= 2) {
        System.arraycopy(nums, 0, array, 0, nums.length - 1);
      }
      return array;
    }
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i != index) {
        array[j++] = nums[i];
      }
    }

    return array;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public void backtrack(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {
      // 所有数都填完了
      if (first == n) {
        res.add(new ArrayList<>(output));
      }
      for (int i = first; i < n; i++) {
        // 动态维护数组
        Collections.swap(output, first, i);
        // 继续递归填下一个数
        backtrack(n, output, res, first + 1);
        // 撤销操作
        Collections.swap(output, first, i);
      }
    }

    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> res = new LinkedList<>();
      ArrayList<Integer> output = new ArrayList<>();
      for (int num : nums) {
        output.add(num);
      }

      int n = nums.length;
      backtrack(n, output, res, 0);
      return res;
    }
  }
}
