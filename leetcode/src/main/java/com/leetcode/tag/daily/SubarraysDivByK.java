package com.leetcode.tag.daily;

/**
 * 974. 和可被 K 整除的子数组
 */
public class SubarraysDivByK {
  public int subarraysDivByK(int[] A, int K) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      int sum = 0;
      for (int j = i; j < A.length; j++) {
        sum += A[j];
        if (sum % K == 0) {
          count++;
        }
      }
    }
    return count;
  }
}
