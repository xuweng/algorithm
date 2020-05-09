package com.leetcode.tag.divide;

/**
 * 面试题 16.17. 连续数列
 */
public class ContiguousSequenceLcci {
  /**
   * dp定义巧妙.dp定义巧妙.dp定义巧妙.dp定义巧妙.dp定义巧妙
   *
   * @param nums
   * @return
   */
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length <= 0) {
      return 0;
    }

    // dp数组
    int[] dp = new int[nums.length];
    // 初始化
    dp[0] = nums[0];
    int max = dp[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = (dp[i - 1] <= 0) ? nums[i] : dp[i - 1] + nums[i];
      max = Math.max(max, dp[i]);
    }

    return max;
  }

  class Solution {
    /**
     * 作者：xiang-ri-kui-40
     * 链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci/solution/fen-zhi-fa-by-xiang-ri-kui-40/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
      int b = nums[0];
      int sum = b;
      for (int i = 1; i < nums.length; i++) {
        if (b < 0) {
          b = nums[i];
        } else {
          b += nums[i];
        }
        if (b > sum) {
          sum = b;
        }
      }
      return sum;
    }
  }

  class Solution2 {
    int[] nums;

    public int maxSubArray(int[] nums) {
      this.nums = nums;
      return MaxSum(0, nums.length - 1);
    }

    /**
     * 分治套路
     *
     * <p>此函数计算nums[left]到nums[right]之间的最大连续总和 最大连续总和只可能出现在数组的左边，或者右边，或者中间
     */
    private int MaxSum(int left, int right) {
      if (left == right) {
        return nums[left];
      }
      int mid = (left + right) / 2;
      int leftMaxSum = MaxSum(left, mid); // 左边部分最大连续总和
      int rightMaxSum = MaxSum(mid + 1, right); // //右边部分最大连续总和

      // 下面计算中间部分最大连续总和
      int sum = 0;
      int leftBorderMax = Integer.MIN_VALUE;
      for (int i = mid; i >= left; i--) { // 从中间往左边延伸,找到左边边界最大和
        sum += nums[i];
        leftBorderMax = Math.max(leftBorderMax, sum);
      }
      sum = 0;
      int rightBorderMax = Integer.MIN_VALUE;
      for (int i = mid + 1; i <= right; i++) { // 从中间往右边延伸,找到右边边界最大和
        sum += nums[i];
        rightBorderMax = Math.max(rightBorderMax, sum);
      }
      // 返回左边，右边，中间之中的最大值
      return Math.max(leftMaxSum, Math.max(rightMaxSum, leftBorderMax + rightBorderMax));
    }
  }
}
