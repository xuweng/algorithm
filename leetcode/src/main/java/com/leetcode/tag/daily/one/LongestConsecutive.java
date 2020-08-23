package com.leetcode.tag.daily.one;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>记住思路
 *
 * <p>记住思路
 *
 * <p>记住思路
 *
 * <p>记住思路
 *
 * <p>记住思路
 *
 * <p>记住思路
 */
public class LongestConsecutive {
  public int longestConsecutive(int[] nums) {
    return 0;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/zui-chang-lian-xu-xu-lie-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int longestConsecutive(int[] nums) {
      Set<Integer> numSet = new HashSet<>();
      for (int num : nums) {
        numSet.add(num);
      }

      int longestStreak = 0;

      for (int num : numSet) {
        if (!numSet.contains(num - 1)) {
          int currentNum = num;
          int currentStreak = 1;

          while (numSet.contains(currentNum + 1)) {
            currentNum += 1;
            currentStreak += 1;
          }

          longestStreak = Math.max(longestStreak, currentStreak);
        }
      }

      return longestStreak;
    }
  }
}
