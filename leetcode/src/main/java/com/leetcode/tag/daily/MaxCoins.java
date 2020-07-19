package com.leetcode.tag.daily;

import java.util.Arrays;

/**
 * 312. 戳气球
 *
 * 分治
 *
 * 记忆化
 *
 * 递归
 *
 * 心中有概念
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 */
public class MaxCoins {
  class Solution {
    int[][] me;

    public int maxCoins(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      if (nums.length == 1) {
        return nums[0];
      }
      int newLength = nums.length + 2;
      me = new int[newLength][newLength];

      int[] newNums = new int[newLength];
      // 新数组首和尾都插入1
      newNums[0] = 1;
      newNums[newNums.length - 1] = 1;
      System.arraycopy(nums, 0, newNums, 1, nums.length);
      return re(newNums, 1, newNums.length - 2);
    }

    /**
     * 分治
     *
     * <p>记忆化
     *
     * <p>递归
     *
     * <p>戳气球的操作，发现这会导致两个气球从不相邻变成相邻，使得后续操作难以处理。
     *
     * <p>于是我们倒过来看这些操作，将全过程看作是每次添加一个气球。
     *
     * <p>第low和第high都是不可戳
     *
     * @param nums
     * @param low
     * @param high
     * @return
     */
    public int re(int[] nums, int low, int high) {
      if (me[low][high] != 0) {
        return me[low][high];
      }
      // 递归终止条件
      // 终止条件特别麻烦
      if (high - low <= 1) {
        return 0;
      }
      int max = Integer.MIN_VALUE;
      // i的范围?low<i<high
      for (int i = low; i <= high; i++) {
        // 将全过程看作是每次添加一个气球
        max =
                Math.max(max, re(nums, low, i) + re(nums, i, high) + nums[low] * nums[i] * nums[high]);
      }
      me[low][high] = max;
      return max;
    }
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/burst-balloons/solution/chuo-qi-qiu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public int[][] rec;
    public int[] val;

    public int maxCoins(int[] nums) {
      int n = nums.length;
      val = new int[n + 2];
      for (int i = 1; i <= n; i++) {
        val[i] = nums[i - 1];
      }
      val[0] = val[n + 1] = 1;
      rec = new int[n + 2][n + 2];
      for (int i = 0; i <= n + 1; i++) {
        Arrays.fill(rec[i], -1);
      }
      return solve(0, n + 1);
    }

    public int solve(int left, int right) {
      if (left >= right - 1) {
        return 0;
      }
      if (rec[left][right] != -1) {
        return rec[left][right];
      }
      for (int i = left + 1; i < right; i++) {
        int sum = val[left] * val[i] * val[right];
        sum += solve(left, i) + solve(i, right);
        rec[left][right] = Math.max(rec[left][right], sum);
      }
      return rec[left][right];
    }
  }
}
