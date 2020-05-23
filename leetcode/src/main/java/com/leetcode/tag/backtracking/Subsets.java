package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 */
public class Subsets {
  /**
   * 老方法
   *
   * <p>思路正确
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = re(nums, nums.length - 1);
    result.add(new ArrayList<>());

    return result;
  }

  public List<List<Integer>> re(int[] nums, int n) {
    List<List<Integer>> result = new ArrayList<>();
    if (n <= 0) {
      List<Integer> list = new ArrayList<>();
      list.add(nums[n]);
      result.add(list);
      return result;
    }

    List<List<Integer>> lists = re(nums, n - 1);
    if (lists == null) {
      return result;
    }
    List<Integer> list1 = new ArrayList<>();
    list1.add(nums[n]);
    result.add(list1);
    for (List<Integer> list : lists) {
      result.add(list);
      List<Integer> list2 = new ArrayList<>(list);
      list2.add(nums[n]);
      result.add(list2);
    }

    return result;
  }

  /**
   * 作者：ctrl-cv
   * 链接：https://leetcode-cn.com/problems/power-set-lcci/solution/javahui-su-jie-jue-zi-ji-wen-ti-by-ctrl-cv/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      // 结果集合
      List<List<Integer>> list = new ArrayList<>();
      list.add(new ArrayList<>());
      // 回溯方法
      backtrack(list, new ArrayList<>(), nums, 0);

      return list;
    }

    /**
     * 递归树
     *
     * <p>递归树
     *
     * <p>递归树
     *
     * <p>常规:root到叶子结点就是一个结果
     *
     * <p>选择一个就是结果.结果累加.
     *
     * @param list
     * @param tempList
     * @param nums
     * @param start
     */
    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
      for (int i = start; i < nums.length; i++) {
        // 选择nums[i]
        tempList.add(nums[i]);
        list.add(new ArrayList<>(tempList));
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}
