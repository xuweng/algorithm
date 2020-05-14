package com.leetcode.tag.bit;

import java.util.*;

/**
 * 260. 只出现一次的数字 III
 */
public class SingleNumberIII {
  public int[] singleNumber(int[] nums) {
    return null;
  }

  /**
   * 作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/single-number-iii/solution/zhi-chu-xian-yi-ci-de-shu-zi-iii-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int[] singleNumber(int[] nums) {
      Map<Integer, Integer> hashmap = new HashMap<>();
      for (int n : nums) {
        hashmap.put(n, hashmap.getOrDefault(n, 0) + 1);
      }

      int[] output = new int[2];
      int idx = 0;
      for (Map.Entry<Integer, Integer> item : hashmap.entrySet()) {
        if (item.getValue() == 1) {
          output[idx++] = item.getKey();
        }
      }

      return output;
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/single-number-iii/solution/zhi-chu-xian-yi-ci-de-shu-zi-iii-by-leetcode/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
      public int[] singleNumber(int[] nums) {
        // difference between two numbers (x and y) which were seen only once
        int bitmask = 0;
        for (int num : nums) {
          bitmask ^= num;
        }

        // rightmost 1-bit diff between x and y
        int diff = bitmask & (-bitmask);

        int x = 0;
        // bitmask which will contain only x
        for (int num : nums) {
          if ((num & diff) != 0) {
            x ^= num;
          }
        }

        return new int[]{x, bitmask ^ x};
      }
    }

    /**
     * 巧妙
     *
     * <p>放入 set ，出现重复移除，剩余为出现一次数字
     */
    public int[] singleNumber1(int[] nums) {
      // set删除已经重复的数,只保留没有重复的数
      Set<Integer> dup = new HashSet<>();
      for (int num : nums) {
        // true (if this set did not already contain the specified)
        if (!dup.add(num)) {
          dup.remove(num);
        }
      }
      Iterator<Integer> iterator = dup.iterator();
      return new int[]{iterator.next(), iterator.next()};
    }
  }
}
