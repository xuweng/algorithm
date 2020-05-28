package com.leetcode.tag.daily;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 394. 字符串解码
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
}
