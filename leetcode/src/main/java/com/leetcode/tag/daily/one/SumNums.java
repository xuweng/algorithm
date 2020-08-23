package com.leetcode.tag.daily.one;

/**
 * 面试题64. 求1+2+…+n
 */
public class SumNums {
  public int sumNums(int n) {
    return 0;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof/solution/qiu-12n-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 逻辑运算符的短路性质
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
      boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
      return n;
    }
  }

  class Solution1 {
    int[] test = new int[]{0};

    public int sumNums(int n) {
      try {
        return test[n];
      } catch (Exception e) {
        return n + sumNums(n - 1);
      }
    }
  }
}
