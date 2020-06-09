package com.leetcode.tag;

public class Utils {
  /**
   * 数字转字母 1-26 ： A-Z
   *
   * @param num
   * @return
   */
  public static String numberToLetter(int num) {
    if (num <= 0) {
      return null;
    }
    StringBuilder letter = new StringBuilder();
    num--;
    do {
      if (letter.length() > 0) {
        num--;
      }
      letter.insert(0, ((char) (num % 26 + (int) 'a')));
      num = (num - num % 26) / 26;
    } while (num > 0);

    return letter.toString();
  }

  /**
   * 字母转数字 A-Z ：1-26
   *
   * @param letter
   * @return
   */
  public static int letterToNumber(String letter) {
    int length = letter.length();
    int num = 0;
    int number = 0;
    for (int i = 0; i < length; i++) {
      char ch = letter.charAt(length - i - 1);
      num = (int) (ch - 'A' + 1);
      num *= Math.pow(26, i);
      number += num;
    }
    return number;
  }
}
