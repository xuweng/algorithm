package com.leetcode.tag.daily;

/**
 * 67. 二进制求和
 */
public class AddBinary {
  public String addBinary(String a, String b) {
    return null;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/add-binary/solution/er-jin-zhi-qiu-he-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 先将 a 和 b 转化成十进制数，求和后再转化为二进制数
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
      return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }
  }
}
