package com.leetcode.tag.divide;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 */
public class MajorityElement {
  public int majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);

      if (map.get(i) > nums.length / 2) {
        return i;
      }
    }
    return 0;
  }

  /**
   * 次数和具体数字
   *
   * @param nums
   * @param low
   * @param high
   * @return
   */
  public int divide(int[] nums, int low, int high) {
    int mid = low + (high - low) / 2;
    int n = high - low + 1;

    return 0;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    private int countInRange(int[] nums, int num, int lo, int hi) {
      int count = 0;
      for (int i = lo; i <= hi; i++) {
        if (nums[i] == num) {
          count++;
        }
      }
      return count;
    }

    /**
     * 我们就可以使用分治法解决这个问题：将数组分成左右两部分，
     *
     * <p>分别求出左半部分的众数 a1 以及右半部分的众数 a2，随后在 a1 和 a2 中选出正确的众数。
     *
     * <p>我们使用经典的分治算法递归求解，直到所有的子问题都是长度为 1 的数组。
     *
     * <p>长度为 1 的子数组中唯一的数显然是众数，直接返回即可。如果回溯后某区间的长度大于
     *
     * <p>1，我们必须将左右子区间的值合并。如果它们的众数相同，那么显然这一段区间的众数是它们相同的值。
     *
     * <p>否则，我们需要比较两个众数在整个区间内出现的次数来决定该区间的众数。
     *
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    private int majorityElementRec(int[] nums, int lo, int hi) {
      // base case; the only element in an array of size 1 is the majority
      // element.
      if (lo == hi) {
        return nums[lo];
      }

      // recurse on left and right halves of this slice.
      int mid = (hi - lo) / 2 + lo;
      int left = majorityElementRec(nums, lo, mid);
      int right = majorityElementRec(nums, mid + 1, hi);

      // if the two halves agree on the majority element, return it.
      if (left == right) {
        return left;
      }

      // otherwise, count each element and return the "winner".
      int leftCount = countInRange(nums, left, lo, mid);
      int rightCount = countInRange(nums, right, mid + 1, hi);

      return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
      return majorityElementRec(nums, 0, nums.length - 1);
    }
  }
}
