package com.leetcode.tag.daily;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 十分钟直接看答案
 *
 * <p>394. 字符串解码
 */
public class DecodeString {
  public String decodeString(String s) {
    return null;
  }

  /**
   * 如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈
   *
   * <p>如果当前的字符为字母或者左括号，直接进栈
   *
   * <p>如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，此时取出栈顶的数字（此时栈顶一定是数字，
   *
   * <p>想想为什么？），就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/decode-string/solution/zi-fu-chuan-jie-ma-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    int ptr;

    /**
     * 字母、数字和括号看成是独立的 TOKEN，并用栈来维护这些 TOKEN
     *
     * <p>当前字符为右括号就出栈
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
      LinkedList<String> stk = new LinkedList<>();
      ptr = 0;

      while (ptr < s.length()) {
        char cur = s.charAt(ptr);
        if (Character.isDigit(cur)) {
          // 获取一个数字并进栈
          String digits = getDigits(s);
          stk.addLast(digits);
        } else if (Character.isLetter(cur) || cur == '[') {
          // 获取一个字母并进栈
          stk.addLast(String.valueOf(s.charAt(ptr++)));
        } else {
          ++ptr;
          LinkedList<String> sub = new LinkedList<>();
          while (!"[".equals(stk.peekLast())) {
            // 添加到尾部
            sub.addLast(stk.removeLast());
          }
          // 反转数据
          Collections.reverse(sub);
          // 左括号出栈
          stk.removeLast();
          // 此时栈顶为当前 sub 对应的字符串应该出现的次数
          int repTime = Integer.parseInt(stk.removeLast());
          StringBuilder t = new StringBuilder();
          String o = getString(sub);
          // 构造字符串
          while (repTime-- > 0) {
            t.append(o);
          }
          // 将构造好的字符串重新入栈
          stk.addLast(t.toString());
        }
      }

      return getString(stk);
    }

    /**
     * 数字可以多个字符
     *
     * @param s
     * @return
     */
    public String getDigits(String s) {
      StringBuilder ret = new StringBuilder();
      while (Character.isDigit(s.charAt(ptr))) {
        ret.append(s.charAt(ptr++));
      }
      return ret.toString();
    }

    public String getString(LinkedList<String> v) {
      StringBuilder ret = new StringBuilder();
      for (String s : v) {
        ret.append(s);
      }
      return ret.toString();
    }
  }

  /**
   * 方法二：递归
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/decode-string/solution/zi-fu-chuan-jie-ma-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    String src;
    int ptr;

    public String decodeString(String s) {
      src = s;
      ptr = 0;
      return getString();
    }

    /**
     * 下面我们可以来讲讲这样做的依据，涉及到《编译原理》相关内容，感兴趣的同学可以参考阅读。
     *
     * <p>根据题目的定义，我们可以推导出这样的巴科斯范式（BNF）：
     *
     * <p>\begin{aligned} {\rm String} &\rightarrow { \rm Digits \, [String] \, String \, | \, Alpha
     * \, String \, | \, \epsilon } \\ {\rm Digits} &\rightarrow { \rm Digit \, Digits \, | \, Digit
     * } \\ {\rm Alpha} &\rightarrow { a | \cdots | z | A | \cdots | Z } \\ {\rm Digit} &\rightarrow
     * { 0 | \cdots | 9 } \\ \end{aligned} String Digits Alpha Digit ​
     *
     * <p>→Digits[String]String∣AlphaString∣ϵ →DigitDigits∣Digit →a∣⋯∣z∣A∣⋯∣Z →0∣⋯∣9 ​
     *
     * <p>DigitDigit 表示十进制数位，可能的取值是 0 到 9 之间的整数
     *
     * <p>AlphaAlpha 表示字母，可能的取值是大小写字母的集合，共 52 个
     *
     * <p>DigitDigit 表示一个整数，它的组成是
     *
     * <p>DigitDigit 出现一次或多次
     *
     * <p>StringString 代表一个代解析的字符串，它可能有三种构成，如
     *
     * <p>ϵ 表示空串，即没有任何子字符
     *
     * @return
     */
    public String getString() {
      if (ptr == src.length() || src.charAt(ptr) == ']') {
        // String -> EPS
        return "";
      }

      char cur = src.charAt(ptr);
      int repTime = 1;
      String ret = "";

      if (Character.isDigit(cur)) {
        // String -> Digits [ String ] String
        // 解析 Digits
        repTime = getDigits();
        // 过滤左括号
        ++ptr;
        // 解析 String.递归求解[]里面的String
        String str = getString();
        // 过滤右括号
        ++ptr;
        // 构造字符串
        while (repTime-- > 0) {
          ret += str;
        }
      } else if (Character.isLetter(cur)) {
        // String -> Char String
        // 解析 Char
        ret = String.valueOf(src.charAt(ptr++));
      }

      return ret + getString();
    }

    /**
     * 数字可以不止一个字符
     *
     * <p>3333[a]2[bc]
     *
     * @return
     */
    public int getDigits() {
      int ret = 0;
      while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
        // 移动ptr
        ret = ret * 10 + src.charAt(ptr++) - '0';
      }
      return ret;
    }
  }
}
