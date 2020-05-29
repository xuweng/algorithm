package com.leetcode.tag.daily;

public class HouseRobber {
  /**
   * 用 dp[i] 表示前 i 间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：
   *
   * <p>dp[i]=max(dp[i−2]+nums[i],dp[i−1])
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dp[i] = i >= 2 ? Math.max(dp[i - 1], dp[i - 2] + nums[i]) : Math.max(nums[i], dp[i - 1]);
    }
    return dp[dp.length - 1];
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int rob(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      int length = nums.length;
      if (length == 1) {
        return nums[0];
      }
      int[] dp = new int[length];
      dp[0] = nums[0];
      dp[1] = Math.max(nums[0], nums[1]);
      for (int i = 2; i < length; i++) {
        dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
      }
      return dp[length - 1];
    }
  }
}
