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

  /**
   * 方法一：模拟
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/add-binary/solution/er-jin-zhi-qiu-he-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    /**
     * 在十进制的计算中「逢十进一」，二进制中我们需要「逢二进一」。
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
      StringBuffer ans = new StringBuffer();

      int n = Math.max(a.length(), b.length()), carry = 0;
      for (int i = 0; i < n; ++i) {
        carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
        carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
        ans.append((char) (carry % 2 + '0'));
        carry /= 2;
      }

      if (carry > 0) {
        ans.append('1');
      }
      ans.reverse();

      return ans.toString();
    }
  }
}
