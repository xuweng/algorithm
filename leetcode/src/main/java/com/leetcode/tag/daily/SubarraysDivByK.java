package com.leetcode.tag.daily;

import java.util.stream.IntStream;

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

  static class S {
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
      // 连续子数组
      // mid在横跨这部分.与左边的mid重复
      // left:low---->mid
      // 横跨mid计算错误.横跨必须left+mid+right
      // 计算横跨mid:O(n3)
      int midCunt = 0;
      for (int i = mid + 1; i <= high; i++) {
        for (int j = mid; j >= low; j--) {
          if (sum(A, j, i) % K == 0) {
            midCunt++;
          }
        }
      }
      return left + right + midCunt;
    }

    public int sum(int[] a, int i, int j) {
      return IntStream.rangeClosed(i, j).map(k -> a[k]).sum();
    }
  }
}
