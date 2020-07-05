package com.leetcode.tag.contest;

import java.util.Arrays;

/**
 * 5452. 判断能否形成等差数列
 */
public class CanMakeArithmeticProgression {
  /**
   * 2 <= arr.length <= 1000
   *
   * <p>-10^6 <= arr[i] <= 10^6
   *
   * @param arr
   * @return
   */
  public boolean canMakeArithmeticProgression(int[] arr) {
    if (arr == null || arr.length == 0) {
      return false;
    }
    Arrays.sort(arr);

    int pre = 0;
    int cha = arr[1] - arr[0];
    for (int i = 1; i < arr.length; i++) {
      int cha1 = arr[i] - arr[pre];
      if (cha != cha1) {
        return false;
      }
      pre = i;
    }

    return true;
  }
}
