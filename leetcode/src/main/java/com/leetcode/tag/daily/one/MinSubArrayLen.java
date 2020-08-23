package com.leetcode.tag.daily.one;

import java.util.Arrays;

/**
 * 209. 长度最小的子数组
 */
public class MinSubArrayLen {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] preSum = new int[nums.length];
    preSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      preSum[i] = preSum[i - 1] + nums[i];
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < preSum.length; i++) {
      int sum;
      for (int j = i; j < preSum.length; j++) {
        if (i == 0) {
          sum = preSum[j];
        } else {
          sum = preSum[j] - preSum[i] + nums[i];
        }
        if (sum >= s) {
          result = Math.min(result, j - i + 1);
          break;
        }
      }
    }
    return (result == Integer.MAX_VALUE) ? 0 : result;
  }

  /**
   * 方法一：暴力法
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int minSubArrayLen(int s, int[] nums) {
      int n = nums.length;
      if (n == 0) {
        return 0;
      }
      int ans = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < n; j++) {
          sum += nums[j];
          if (sum >= s) {
            ans = Math.min(ans, j - i + 1);
            break;
          }
        }
      }
      return ans == Integer.MAX_VALUE ? 0 : ans;
    }
  }

  /**
   * 方法二：前缀和 + 二分查找
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    /**
     * 这道题保证了数组中每个元素都为正，所以前缀和一定是递增的，这一点保证了二分的正确性。
     *
     * <p>如果题目没有说明数组中每个元素都为正，这里就不能使用二分来查找这个位置了
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
      int n = nums.length;
      if (n == 0) {
        return 0;
      }
      int ans = Integer.MAX_VALUE;
      int[] sums = new int[n + 1];
      // 为了方便计算，令 size = n + 1
      // sums[0] = 0 意味着前 0 个元素的前缀和为 0
      // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
      // 以此类推
      for (int i = 1; i <= n; i++) {
        sums[i] = sums[i - 1] + nums[i - 1];
      }
      for (int i = 1; i <= n; i++) {
        int target = s + sums[i - 1];
        int bound = Arrays.binarySearch(sums, target);
        if (bound < 0) {
          bound = -bound - 1;
        }
        if (bound <= n) {
          ans = Math.min(ans, bound - (i - 1));
        }
      }
      return ans == Integer.MAX_VALUE ? 0 : ans;
    }
  }

  /**
   * 方法三：双指针
   *
   * <p>同向双指针
   *
   * <p>滑动窗口
   *
   * <p>滑动窗口
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/chang-du-zui-xiao-de-zi-shu-zu-by-leetcode-solutio/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution2 {
    /**
     * 扩张窗口：找可行解，找到了就不再扩张
     *
     * <p>收缩窗口：在长度上优化该可行解，直到条件被破坏
     *
     * <p>寻找下一个可行解，然后再优化……
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
      int n = nums.length;
      if (n == 0) {
        return 0;
      }
      int ans = Integer.MAX_VALUE;
      // end指针扩大窗口。start指针收缩窗口
      int start = 0, end = 0;
      int sum = 0;
      while (end < n) { // 扩张窗口
        sum += nums[end];
        while (sum >= s) { // 收缩窗口
          ans = Math.min(ans, end - start + 1);
          sum -= nums[start];
          // 收缩窗口
          start++;
        }
        // 扩张窗口
        end++;
      }
      return ans == Integer.MAX_VALUE ? 0 : ans;
    }
  }
}
