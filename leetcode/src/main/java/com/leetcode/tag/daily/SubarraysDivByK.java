package com.leetcode.tag.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续子数组问题的时候，我们使用前缀和来解决。
 *
 * <p>我们令 P[i] = A[0] + A[1] + ... + A[i]。
 *
 * <p>那么每个连续子数组的和 sum(i,j) 就可以写成 P[j] - P[i-1]
 *
 * <p>滑动窗口?
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
    int[] preSum;

    public int subarraysDivByK(int[] A, int K) {
      if (A == null || A.length == 0) {
        return 0;
      }
      preSum = new int[A.length];
      preSum[0] = A[0];
      for (int i = 1; i < A.length; i++) {
        preSum[i] = preSum[i - 1] + A[i];
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
      //      return IntStream.rangeClosed(i, j).map(k -> a[k]).sum();
      if (i == j) {
        return a[i];
      }
      if (i == 0) {
        return preSum[j];
      }
      return preSum[j] - preSum[i - 1];
    }
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/solution/he-ke-bei-k-zheng-chu-de-zi-shu-zu-by-leetcode-sol/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 方法一：哈希表 + 逐一统计
     *
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
      Map<Integer, Integer> record = new HashMap<>();
      record.put(0, 1);
      int sum = 0, ans = 0;
      for (int elem : A) {
        sum += elem;
        // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
        int modulus = (sum % K + K) % K;
        int same = record.getOrDefault(modulus, 0);
        ans += same;
        record.put(modulus, same + 1);
      }
      return ans;
    }
  }

  class S1 {
    class Solution {
      public int subarraysDivByK(int[] A, int K) {
        int sum = 0, counter = 0;
        int[] remainders = new int[K];
        remainders[0] = 1;

        for (int a : A) {
          sum += a;
          int remainder = Math.floorMod(sum, K);
          counter += remainders[remainder];
          ++remainders[remainder];
        }

        return counter;
      }
    }
  }
}
