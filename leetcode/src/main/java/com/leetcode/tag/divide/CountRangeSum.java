package com.leetcode.tag.divide;

/**
 * 327. 区间和的个数
 */
public class CountRangeSum {
  /**
   * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
   *
   * <p>优化内循环?
   *
   * @param nums
   * @param lower
   * @param upper
   * @return
   */
  public int countRangeSum(int[] nums, int lower, int upper) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      long sum = 0;
      for (int j = i; j < nums.length; j++) {
        // 相加会导致大数溢出
        // 相乘会导致大数溢出
        sum += nums[j];
        if (sum >= lower && sum <= upper) {
          count++;
        }
      }
    }
    return count;
  }

  static class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
      int n = nums.length;
      aux = new long[n + 1];
      return countRangeSum(preSum(nums), 0, n, lower, upper);
    }

    /**
     * 前缀和
     *
     * @param nums
     * @return
     */
    public long[] preSum(int[] nums) {
      int n = nums.length;
      // 前缀和
      long[] sums = new long[n + 1];
      aux = new long[n + 1];
      for (int i = 1; i <= n; i++) {
        sums[i] = nums[i - 1] + sums[i - 1];
      }

      return sums;
    }

    private static long[] aux;

    private int countRangeSum(long[] sums, int lo, int hi, int lower, int upper) {
      // 计算sum的lo-hi能构成多少个,即nums的lo-(hi-1)构成的
      if (lo >= hi) {
        return 0;
      }
      int mid = lo + (hi - lo) / 2;
      int leftCnt = countRangeSum(sums, lo, mid, lower, upper);
      int rightCnt = countRangeSum(sums, mid + 1, hi, lower, upper);
      int cnt = 0;
      int leftP = mid + 1, rightP = mid + 1;
      for (int i = lo; i <= mid; i++) {
        while (leftP <= hi && sums[leftP] - sums[i] < lower) {
          leftP++;
        }
        while (rightP <= hi && sums[rightP] - sums[i] <= upper) {
          rightP++;
        }

        cnt += rightP - leftP;
      }

      mergerSort(sums, lo, mid, hi);
      return leftCnt + rightCnt + cnt;
    }

    private void mergerSort(long[] sums, int lo, int mid, int hi) {
      if (hi + 1 - lo >= 0) {
        System.arraycopy(sums, lo, aux, lo, hi + 1 - lo);
      }
      int l = lo, r = mid + 1;
      for (int i = lo; i <= hi; i++) {
        if (l > mid) {
          sums[i] = aux[r++];
        } else if (r > hi) {
          sums[i] = aux[l++];
        } else if (aux[l] < aux[r]) {
          sums[i] = aux[l++];
        } else {
          sums[i] = aux[r++];
        }
      }
    }
  }

  class Solution1 {
    public int countRangeSum(int[] nums, int lower, int upper) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      long[] mark = new long[nums.length + 1];
      long[] temp = new long[nums.length + 1];
      long sum = 0;
      mark[0] = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        mark[i + 1] = sum;
      }
      return countRangeSum2(mark, temp, lower, upper, 0, mark.length - 1);
    }

    public int countRangeSum2(long[] mark, long[] temp, int lower, int upper, int i, int j) {
      if (i >= j) {
        return 0;
      }
      int m = i + (j - i) / 2;
      // left i, m
      int left_sum = countRangeSum2(mark, temp, lower, upper, i, m);
      // right m+1, j
      int right_sum = countRangeSum2(mark, temp, lower, upper, m + 1, j);

      int sum = 0;
      int left = i;
      int l = m + 1;
      int h = m + 1;
      while (left <= m && l <= j) {
        if (mark[l] - mark[left] < lower) {
          l++;
          continue;
        }

        while (h <= j && mark[h] - mark[left] <= upper) {
          h++;
        }
        sum += (h - l);
        left++;
      }

      // sort
      int f = i;
      int s = m + 1;
      int n = i;
      while (f <= m || s <= j) {
        if (f > m) {
          temp[n] = mark[s];
          n++;
          s++;
          continue;
        }
        if (s > j) {
          temp[n] = mark[f];
          n++;
          f++;
          continue;
        }
        if (mark[f] <= mark[s]) {
          temp[n] = mark[f];
          n++;
          f++;
        } else {
          temp[n] = mark[s];
          n++;
          s++;
        }
      }
      if (j + 1 - i >= 0) {
        System.arraycopy(temp, i, mark, i, j + 1 - i);
      }
      // System.out.println("i:" + i +" j:" + j + " sum:" + (left_sum + right_sum + sum));
      return left_sum + right_sum + sum;
    }
  }
}
