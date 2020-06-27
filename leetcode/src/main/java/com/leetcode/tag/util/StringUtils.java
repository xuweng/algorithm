package com.leetcode.tag.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
  /**
   * 判断一个字符串是否含有数字
   *
   * @param content
   * @return
   */
  public static boolean hasDigit(String content) {
    boolean flag = false;
    final Pattern p = Pattern.compile(".*\\d+.*");
    Matcher m = p.matcher(content);
    if (m.matches()) {
      flag = true;
    }
    return flag;
  }
}
