package com.leetcode.tag.daily.one;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 */
public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    return 0;
  }

  /**
   * 枚举第一个元素 a，对于剩下的两个元素 b 和 c
   *
   * <p>方法一：排序 + 双指针
   *
   * <p>这里的「最接近」即为差值的绝对值最小
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/3sum-closest/solution/zui-jie-jin-de-san-shu-zhi-he-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 如果 a+b+c ，那么就将 p_c​ 向左移动一个位置；
     *
     * <p>如果 a+b+c<target，那么就将 p_b​ 向右移动一个位置。
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
      // 防止重复枚举
      Arrays.sort(nums);
      int n = nums.length;
      int best = 10000000;

      // 枚举 a
      for (int i = 0; i < n; ++i) {
        // 保证和上一次枚举的元素不相等(?)
        if (i > 0 && nums[i] == nums[i - 1]) {
          continue;
        }
        // 使用双指针枚举 b 和 c
        int j = i + 1, k = n - 1;
        while (j < k) {
          int sum = nums[i] + nums[j] + nums[k];
          // 如果和为 target 直接返回答案
          if (sum == target) {
            return target;
          }
          // 根据差值的绝对值来更新答案
          if (Math.abs(sum - target) < Math.abs(best - target)) {
            best = sum;
          }
          if (sum > target) {
            // 如果和大于 target，移动 c 对应的指针
            int k0 = k - 1;
            // 移动到下一个不相等的元素
            while (j < k0 && nums[k0] == nums[k]) {
              --k0;
            }
            k = k0;
          } else {
            // 如果和小于 target，移动 b 对应的指针
            int j0 = j + 1;
            // 移动到下一个不相等的元素
            while (j0 < k && nums[j0] == nums[j]) {
              ++j0;
            }
            j = j0;
          }
        }
      }
      return best;
    }
  }
}
