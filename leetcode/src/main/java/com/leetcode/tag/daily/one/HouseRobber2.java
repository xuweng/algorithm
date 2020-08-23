package com.leetcode.tag.daily.one;

/**
 * 213. 打家劫舍 II
 */
public class HouseRobber2 {
  /**
   * 数组是个环，也就是说偷第一家，最后一家就不能偷；偷最后一家，第一家就不能偷。
   *
   * <p>所以，我们问题分成求 nums[0:n - 1]或者 nums[1:n] 这意味着第一个房屋和最后一个房屋是紧挨着的
   *
   * <p>第一个和最后一个不能共存，只能取一个
   *
   * @param nums
   * @return
   */
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length <= 3) {
      return Math.max(nums[0], nums[1]);
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length - 1; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    int max1 = dp[nums.length - 2];

    dp[nums.length - 1] = nums[nums.length - 1];
    dp[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
    for (int i = nums.length - 3; i >= 1; i--) {
      dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
    }
    int max2 = dp[1];

    return Math.max(max1, max2);
  }

  /**
   * 作者：mu-tu-ze-shuai
   * 链接：https://leetcode-cn.com/problems/house-robber-ii/solution/yi-ge-forxun-huan-jie-jue-wen-ti-by-mu-tu-ze-shuai/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 不容易读
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
      if (nums.length == 1) {
        return nums[0];
      }
      int n = nums.length;
      int[] a = new int[n + 1];
      int[] b = new int[n + 1];
      for (int i = 2; i < n + 1; i++) {
        a[i] = Math.max(a[i - 1], a[i - 2] + nums[i - 2]);
        b[i] = Math.max(b[i - 1], b[i - 2] + nums[i - 1]);
      }
      return Math.max(a[n], b[n]);
    }
  }
}
