package com.leetcode.tag.daily;

import java.util.HashMap;

/**
 * 560. 和为K的子数组
 */
public class SubarraySum {
  /**
   * 方法一：枚举
   *
   * <p>优化枚举
   *
   * <p>优化枚举
   *
   * <p>优化枚举
   *
   * <p>优化枚举
   *
   * <p>只会枚举没有用
   *
   * <p>只会枚举没有用
   *
   * @param nums
   * @param k
   * @return
   */
  public int subarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == k) {
          count++;
        }
      }
    }
    return count;
  }

  /**
   * 我们可以基于方法一利用数据结构进行进一步的优化，我们知道方法一的瓶颈在于对每个 i，
   *
   * <p>我们需要枚举所有的 j 来判断是否符合条件，这一步是否可以优化呢？不知道具体的j?能快速计算j?
   *
   * <p>我们定义pre[i] 为 [0..i] 里所有数的和，则 pre[i] 可以由pre[i−1] 递推而来
   *
   * <p>前缀和.递归定义
   *
   * <p>pre[i]=pre[i−1]+nums[i]
   *
   * <p>区间和[j,i]
   *
   * <p>那么「[j..i]这个子数组和为 k 」这个条件我们可以转化为
   *
   * <p>pre[i]−pre[j−1]==k
   *
   * <p>简单移项可得符合条件的下标 j 需要满足.j可以这样计算
   *
   * <p>pre[j−1]==pre[i]−k
   *
   * <p>考虑以 i 结尾的和为 k 的连续子数组个数?以i结尾?
   *
   * <p>方法二：前缀和 + 哈希表优化
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public class Solution {
    /**
     * pre[j−1]==pre[i]−k
     *
     * <p>考虑以 i 结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和为 pre[i]−k即可
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
      int count = 0;
      // 记录 pre[i−1] 的答案
      int pre = 0;
      // 以pre[i]为键，出现pre[i]出现次数为对应的值
      HashMap<Integer, Integer> mp = new HashMap<>();
      mp.put(0, 1);
      for (int num : nums) {
        // pre[i]
        int current = pre + num;
        if (mp.containsKey(current - k)) {
          count += mp.get(current - k);
        }
        mp.put(current, mp.getOrDefault(current, 0) + 1);
        pre = current;
      }
      return count;
    }
  }
}
