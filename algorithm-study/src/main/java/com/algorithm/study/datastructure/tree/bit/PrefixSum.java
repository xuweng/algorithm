package com.algorithm.study.datastructure.tree.bit;

/**
 * 前缀和
 */
public class PrefixSum {
  int[] preSum;

  /**
   * 把对数组 A 的累加依次放入数组 B 中。
   *
   * <p>递推： B[i] = B[i-1] + A[i] ，前提 B[0] = A[0] 。
   *
   * @param array
   * @return
   */
  public void buildPreSum(int[] array) {
    if (array == null || array.length == 0) {
      return;
    }
    preSum = new int[array.length];
    preSum[0] = array[0];

    for (int i = 1; i < array.length; i++) {
      preSum[i] = preSum[i - 1] + array[i];
    }
  }
}
