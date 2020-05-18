package com.leetcode.tag.daily;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct {
  /**
   * 太多判断
   *
   * <p>递归函数定义错误?
   *
   * <p>状态定义错误?状态方程错误?
   *
   * <p>冗余代码太多
   *
   * <p>冗余代码太多
   *
   * <p>找出数组中乘积最大的连续子数组
   *
   * @param nums
   * @return
   */
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[][] dp = new int[nums.length][2];
    dp[0][0] = nums[0];
    dp[0][1] = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == 0) {
        dp[i][0] = 0;
        dp[i][1] = 0;
      } else if (nums[i] < 0) {
        if (dp[i - 1][1] == 0) {
          dp[i][0] = 0;
          dp[i][1] = nums[i];
        } else if (dp[i - 1][1] < 0) {
          dp[i][0] = dp[i - 1][1] * nums[i];
          dp[i][1] = nums[i];
        } else {
          dp[i][0] = nums[i];
          dp[i][1] = dp[i - 1][1] * nums[i];
        }
      } else {
        if (dp[i - 1][1] == 0) {
          dp[i][0] = nums[i];
          dp[i][1] = nums[i];
        } else if (dp[i - 1][1] < 0) {
          dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
          dp[i][1] = dp[i - 1][1] * nums[i];
        } else {
          dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i]);
          dp[i][1] = nums[i];
        }
      }

      max = Math.max(max, dp[i][0]);
    }

    return max;
  }

  public int maxProduct1(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    return re(nums, 0, nums.length - 1);
  }

  public int re(int[] nums, int low, int high) {
    if (low > high) {
      return 0;
    }
    if (low == high) {
      return nums[low];
    }

    int mid = low + (high - low) / 2;
    int left = re(nums, low, mid);
    int right = re(nums, mid + 1, high);

    int leftMax = Integer.MIN_VALUE;
    int leftp = 1;
    for (int i = mid; i >= low; i--) {
      leftp *= nums[i];
      leftMax = Math.max(leftMax, leftp);
    }
    int rightMax = Integer.MIN_VALUE;
    int rithtP = 1;
    for (int i = mid + 1; i <= high; i++) {
      rithtP *= nums[i];
      rightMax = Math.max(rightMax, rithtP);
    }
    int midMax = 0;
    if ((leftMax > 0 && rightMax > 0) || (leftMax < 0 && rightMax < 0)) {
      midMax = leftMax * rightMax;
    } else if (leftMax < 0 && rightMax > 0) {
      midMax = rightMax;
    } else if (leftMax > 0 && rightMax < 0) {
      midMax = leftMax;
    } else if (leftMax == 0) {
      if (rightMax > 0) {
        midMax = rightMax;
      } else {
        midMax = leftMax;
      }
    } else if (rightMax == 0) {
      if (leftMax > 0) {
        midMax = leftMax;
      } else {
        midMax = rightMax;
      }
    }
    return Math.max(Math.max(left, right), midMax);
  }

  /**
   * 暴力法
   *
   * <p>枚举所有连续子数组
   *
   * @param nums
   * @return
   */
  public int maxProduct2(int[] nums) {
    // 思路：暴力穷举所有子数组，然后得出最大值
    int len = nums.length;
    if (len == 0) {
      return 0;
    }
    long max = Long.MIN_VALUE;
    for (int i = 0; i < len; i++) {
      int numCount = 1;
      for (int j = i; j < len; j++) {
        numCount *= nums[j];
        max = Math.max(numCount, max);
      }
    }
    return (int) max;
  }
}
