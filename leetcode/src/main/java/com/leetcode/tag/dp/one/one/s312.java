package com.leetcode.tag.dp.one.one;

/**
 * 312. 戳气球
 *
 * <p>最直接的做法就是暴力所有可能的扎破气球的顺序，但这个数量级很大，有N×(N−1)×(N−2)×...×1 种可能，时间复杂度为O(N!)。
 *
 * <p>这种最直接的暴力会有很多重复计算，比如有四个气球，你先扎破第一个再扎破第二个，跟你先扎破第二个在扎破第一个，
 *
 * <p>最后都是剩下第三个和第四个气球，因此对于剩余第三个和第四个气球这种情况只需要计算一次就可以了。
 *
 * <p>作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/burst-balloons/solution/chuo-qi-qiu-by-leetcode/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class s312 {
  /**
   * 定义方法 dp，使其返回开区间 (left, right) 中所能得到的最大金币数
   *
   * <p>方法一：动态规划(自顶向下）
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/burst-balloons/solution/chuo-qi-qiu-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int maxCoins(int[] nums) {

    // reframe the problem
    int n = nums.length + 2;
    int[] new_nums = new int[n];

    System.arraycopy(nums, 0, new_nums, 1, nums.length);

    new_nums[0] = new_nums[n - 1] = 1;

    // cache the results of dp
    int[][] memo = new int[n][n];

    // find the maximum number of coins obtained from adding all balloons from (0, len(nums) - 1)
    return dp(memo, new_nums, 0, n - 1);
  }

  public int dp(int[][] memo, int[] nums, int left, int right) {
    // no more balloons can be added
    if (left + 1 == right) return 0;

    // we've already seen this, return from cache
    if (memo[left][right] > 0) return memo[left][right];

    // add each balloon on the interval and return the maximum score
    int ans = 0;
    for (int i = left + 1; i < right; ++i)
      ans =
              Math.max(
                      ans,
                      nums[left] * nums[i] * nums[right]
                              + dp(memo, nums, left, i)
                              + dp(memo, nums, i, right));
    // add to the cache
    memo[left][right] = ans;
    return ans;
  }

  /**
   * 定义方法 dp，使其返回开区间 (left, right) 中所能得到的最大金币数
   *
   * <p>方法二：动态规划（自底向上）
   *
   * @param nums
   * @return
   */
  public int maxCoins2(int[] nums) {
    // reframe the problem
    int n = nums.length + 2;
    int[] new_nums = new int[n];

    for (int i = 0; i < nums.length; i++) {
      new_nums[i + 1] = nums[i];
    }

    new_nums[0] = new_nums[n - 1] = 1;

    // dp will store the results of our calls
    int[][] dp = new int[n][n];

    // iterate over dp and incrementally build up to dp[0][n-1]
    for (int left = n - 2; left > -1; left--)
      for (int right = left + 2; right < n; right++) {
        for (int i = left + 1; i < right; ++i)
          // same formula to get the best score from (left, right) as before
          dp[left][right] =
                  Math.max(
                          dp[left][right],
                          new_nums[left] * new_nums[i] * new_nums[right] + dp[left][i] + dp[i][right]);
      }

    return dp[0][n - 1];
  }
}
