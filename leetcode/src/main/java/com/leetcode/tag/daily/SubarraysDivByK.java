package com.leetcode.tag.daily;

/**
 * 滑动窗口?
 *
 * <p>区间和?线段树?区间数组?
 *
 * <p>974. 和可被 K 整除的子数组
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

  class S {
    public int subarraysDivByK(int[] A, int K) {
      if (A == null || A.length == 0) {
        return 0;
      }
      return divide(A, K, 0, A.length - 1);
    }

    public int divide(int[] A, int K, int low, int high) {
      if (low >= high) {
        return A[low] % K == 0 ? 1 : 0;
      }
      int mid = low + (high - low) / 2;
      // mid放在左边
      int left = divide(A, K, low, mid);
      int right = divide(A, K, mid + 1, high);
      int leftSum = 0;
      int leftCount = 0;
      // 连续子数组
      // mid在横跨这部分.与左边的mid重复
      // left:low---->mid
      for (int i = mid; i > low; i--) {
        leftSum += A[i];
        if (leftSum % K == 0) {
          leftCount++;
        }
      }
      int rightSum = 0;
      int rightCount = 0;
      for (int i = mid + 1; i < high; i++) {
        rightSum += A[i];
        if (rightSum % K == 0) {
          rightCount++;
        }
      }
      return left + right + leftCount + rightCount;
    }
  }
}
