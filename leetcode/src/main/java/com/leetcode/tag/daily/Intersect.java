package com.leetcode.tag.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 */
public class Intersect {
  /**
   * 我有想到哈希表
   *
   * <p>哈希表
   *
   * <p>哈希表
   *
   * <p>哈希表
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] intersect(int[] nums1, int[] nums2) {
    return null;
  }

  /**
   * 对于一个数字，其在交集中出现的次数等于该数字在两个数组中出现次数的最小值。
   *
   * <p>看题解动画理解
   *
   * <p>看题解动画理解
   *
   * <p>题解动画理解
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      if (nums1.length > nums2.length) {
        return intersect(nums2, nums1);
      }
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums1) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
      int[] intersection = new int[nums1.length];
      int index = 0;
      for (int num : nums2) {
        int count = map.getOrDefault(num, 0);
        if (count > 0) {
          intersection[index++] = num;
          count--;
          if (count > 0) {
            map.put(num, count);
          } else {
            map.remove(num);
          }
        }
      }
      return Arrays.copyOfRange(intersection, 0, index);
    }
  }
}
