package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 */
public class LetterCasePermutation {
  List<String> list = new ArrayList<>();

  /**
   * 递归树
   *
   * <p>递归树
   *
   * <p>递归树
   *
   * <p>递归树
   *
   * <p>原问题
   *
   * <p>找到所有子问题
   *
   * <p>找到所有分支
   *
   * <p>找到所有分支
   *
   * <p>找到所有分支
   *
   * <p>找到所有分支
   *
   * <p>找到所有分支
   *
   * @param S
   * @return
   */
  public List<String> letterCasePermutation(String S) {
    list.add(S);

    re(S, 0, S.length() - 1);

    return list;
  }

  /**
   * 寻找子问题是个难点
   *
   * @param s
   * @param low
   * @param high
   */
  public void re(String s, int low, int high) {
    if (low > high) {
      return;
    }
    Integer[] letter = getLetter(s, low, high);
    for (int i1 = 0; i1 < letter.length; i1++) {
      int i = letter[i1];
      char[] chars = s.toCharArray();
      chars[i] = getChar(chars[i]);
      String s1 = new String(chars);
      list.add(s1);

      if (i1 + 1 < letter.length) {
        re(s1, letter[i1 + 1], high);
      }
    }
  }

  public Integer[] getLetter(String s, int low, int high) {
    if (low > high) {
      return new Integer[0];
    }
    List<Integer> list = new ArrayList<>();
    for (int i = low; i <= high; i++) {
      if (Character.isLetter(s.charAt(i))) {
        list.add(i);
      }
    }

    return list.toArray(new Integer[0]);
  }

  public char getChar(char c) {
    return Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
  }

  /**
   * Character.isDigit( char ch )
   *
   * <p>// 判断ch是否是数字字符，如'1'，'2‘，是返回true。否则返回false
   *
   * <p>1 Character.isLowerCase(c) || Character.isUpperCase(c)
   *
   * <p>//判断ch是否是字母字符，如'a'，'b‘，是返回true。否则返回false
   *
   * <p>1 Character.isLetterOrDigit( char ch )
   *
   * <p>// 判断ch是否是字母或数字字符，如'a'，'b‘，'1'，'2'，是返回true。否则返回false
   *
   * <p>经评论指出，
   *
   * <p>1 Character.isLetter(c) 　　虽然可以判断一些字母，但也有一些非字母会返回 true，比如
   *
   * <p>1 Character.isLetter('ʼ') 　　也会返回 true
   *
   * @param str
   * @return
   */
  public static boolean isDigit(String str, int low, int high) {
    for (int i = low; i <= high; i++) {
      if (!Character.isDigit(str.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
