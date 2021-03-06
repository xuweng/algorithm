package com.leetcode.tag.daily.one;

/**
 * 9. 回文数
 */
public class IsPalindrome {
  public boolean isPalindrome(int x) {
    String str = String.valueOf(x);
    return re(str, 0, str.length() - 1);
  }

  public boolean re(String x, int start, int end) {
    if (start == end) {
      return true;
    }
    final boolean isTrue = x.charAt(start) == x.charAt(end);
    if (end - start == 1) {
      return isTrue;
    }
    return isTrue && re(x, start + 1, end - 1);
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 拆分整数
     *
     * <p>对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，要得到倒数第二位数字，
     *
     * <p>我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10
     *
     * <p>= 122，再求出上一步结果除以 10 的余数
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
      // 特殊情况：
      // 如上所述，当 x < 0 时，x 不是回文数。
      // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
      // 则其第一位数字也应该是 0
      // 只有 0 满足这一属性
      if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false;
      }

      int revertedNumber = 0;
      while (x > revertedNumber) {
        revertedNumber = revertedNumber * 10 + x % 10;
        x /= 10;
      }

      // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
      // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
      // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
      return x == revertedNumber || x == revertedNumber / 10;
    }
  }
}
