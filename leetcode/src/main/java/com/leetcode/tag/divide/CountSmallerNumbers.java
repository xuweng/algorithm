package com.leetcode.tag.divide;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 */
public class CountSmallerNumbers {
  public List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length - 1; i++) {
      int count = 0;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          count++;
        }
      }
      list.add(count);
    }
    list.add(0);
    return list;
  }

  /**
   * 分治.递归
   *
   * <p>重叠子问题?子问题依赖?
   *
   * <p>右子问题没有依赖.左子问题依赖右子问题
   *
   * @param nums
   * @return
   */
  public List<Integer> divide(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }

    return null;
  }

  /**
   * 把输入数组反过来插入一个有序数组（降序）中，插入的位置就是在原数组中位于它右侧的元素的个数
   *
   * <p>反常思维.反常思维.反常思维.反常思维.反常思维.反常思维.反常思维.反常思维.反常思维
   *
   * <p>左----->右
   *
   * <p>右----->左
   *
   * <p>搞破.不搞破
   *
   * @param nums
   * @return
   */
  public List<Integer> countSmaller1(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    int[] sortNums = new int[nums.length];
    List<Integer> list = new ArrayList<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      list.add(insert(sortNums, nums[i]));
    }
    List<Integer> result = new ArrayList<>();
    for (int i = list.size() - 1; i >= 0; i--) {
      result.add(list.get(i));
    }

    return result;
  }

  // 已经排序数组的数量
  int sortNumsCount;

  public int insert(int[] sortNums, int target) {
    if (sortNumsCount == 0) {
      sortNumsCount++;
      sortNums[0] = target;
      return 0;
    }
    int i = sortNumsCount - 1;
    while (i >= 0 && target <= sortNums[i]) {
      sortNums[i + 1] = sortNums[i];
      i--;
    }
    sortNumsCount++;
    sortNums[i + 1] = target;

    return i + 1;
  }
}
