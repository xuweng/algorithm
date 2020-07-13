package com.leetcode.tag.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. 两个数组的交集 II
 *
 * <p>题海战术。见多了也就不觉得奇怪
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
    /**
     * hashmap计数还能这么使用
     *
     * <p>时间复杂度：O(m+n)，其中 m 和 n 分别是两个数组的长度。需要遍历两个数组并对哈希表进行操作，哈希表操作的时间复杂度是
     *
     * <p>O(1)，因此总时间复杂度与两个数组的长度和呈线性关系。
     *
     * <p>空间复杂度O(min(m,n))，其中 m 和 n
     *
     * <p>分别是两个数组的长度。对较短的数组进行哈希表的操作，哈希表的大小不会超过较短的数组的长度。
     *
     * <p>为返回值创建一个数组 intersection，其长度为较短的数组的长度。
     *
     * <p>作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums1 较短数组
     * @param nums2 较长数组
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
      if (nums1.length > nums2.length) {
        // 为了降低空间复杂度，首先遍历较短的数组并在哈希表中记录每个数字以及对应出现的次数，然后遍历较长的数组得到交集。
        // 这个递归厉害。一次性递归。
        return intersect(nums2, nums1);
      }
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums1) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
      // 答案
      int[] intersection = new int[nums1.length];
      int index = 0;
      for (int num : nums2) {
        int count = map.getOrDefault(num, 0);
        if (count <= 0) {
          continue;
        }
        // 存在哈希表
        intersection[index++] = num;
        map.put(num, --count);
      }
      return Arrays.copyOfRange(intersection, 0, index);
    }
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/solution/liang-ge-shu-zu-de-jiao-ji-ii-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);

      int length1 = nums1.length, length2 = nums2.length;
      int[] intersection = new int[Math.min(length1, length2)];
      int index1 = 0, index2 = 0, index = 0;
      while (index1 < length1 && index2 < length2) {
        // 每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位
        if (nums1[index1] < nums2[index2]) {
          index1++;
        } else if (nums1[index1] > nums2[index2]) {
          index2++;
        } else {
          // 如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位
          intersection[index] = nums1[index1];
          index1++;
          index2++;
          index++;
        }
      }
      return Arrays.copyOfRange(intersection, 0, index);
    }
  }
}
