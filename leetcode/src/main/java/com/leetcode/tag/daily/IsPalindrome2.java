package com.leetcode.tag.daily;

/**
 * 审题
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
 * <p>十分钟看答案
 *
 * <p>搞清楚题目
 *
 * <p>搞清楚题目
 *
 * <p>搞清楚题目
 *
 * <p>搞清楚题目
 *
 * <p>搞清楚题目
 *
 * <p>我们将空字符串定义为有效的回文串
 *
 * <p>125. 验证回文串
 */
public class IsPalindrome2 {
  public boolean isPalindrome(String s) {
    return true;
  }

  /**
   * 最简单的方法是对字符串 s 进行一次遍历，并将其中的字母和数字字符进行保留，
   *
   * <p>放在另一个字符串 sgood 中。这样我们只需要判断
   *
   * <p>sgood 是否是一个普通的回文串即可。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/valid-palindrome/solution/yan-zheng-hui-wen-chuan-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public boolean isPalindrome(String s) {
      StringBuilder sgood = new StringBuilder();
      int length = s.length();
      for (int i = 0; i < length; i++) {
        char ch = s.charAt(i);
        // 并将其中的字母和数字字符进行保留
        if (Character.isLetterOrDigit(ch)) {
          sgood.append(Character.toLowerCase(ch));
        }
      }
      // 使用语言中的字符串翻转 API 得到 sgood 的逆序字符串 sgood_rev，只要这两个字符串相同，那么
      // good 就是回文串。
      StringBuffer sgoodRev = new StringBuffer(sgood).reverse();
      return sgood.toString().equals(sgoodRev.toString());
    }
  }

  /**
   * 使用双指针
   */
  class Solution1 {
    public boolean isPalindrome(String s) {
      StringBuilder sgood = new StringBuilder();
      int length = s.length();
      for (int i = 0; i < length; i++) {
        char ch = s.charAt(i);
        if (Character.isLetterOrDigit(ch)) {
          sgood.append(Character.toLowerCase(ch));
        }
      }
      // 使用双指针
      int n = sgood.length();
      int left = 0, right = n - 1;
      while (left < right) {
        if (Character.toLowerCase(sgood.charAt(left))
                != Character.toLowerCase(sgood.charAt(right))) {
          return false;
        }
        ++left;
        --right;
      }
      return true;
    }
  }

  /**
   * 方法二：在原字符串上直接判断
   */
  class Solution3 {
    public boolean isPalindrome(String s) {
      int n = s.length();
      int left = 0, right = n - 1;
      while (left < right) {
        // 防止越界
        // 跳过非法字符
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
          ++left;
        }
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
          --right;
        }
        if (left < right) {
          if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
            return false;
          }
          ++left;
          --right;
        }
      }
      return true;
    }
  }
}
