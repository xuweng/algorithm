package com.leetcode.tag.daily.one;

import com.leetcode.tag.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题46. 把数字翻译成字符串
 */
public class TranslateNum {
  public int translateNum(int num) {
    String str = String.valueOf(num);
    List<String> result = new ArrayList<>();

    backTrack(str, 0, "", result);
    return result.size();
  }

  public void backTrack(String num, int begin, String temp, List<String> result) {
    // 越界统计
    // 一定是越界统计
    if (begin >= num.length()) {
      result.add(temp);
      return;
    }
    int n = Integer.parseInt(String.valueOf(num.charAt(begin)));
    backTrack(num, begin + 1, temp + Utils.getChar(n), result);
    if (num.charAt(begin) != '0' && begin < num.length() - 1) {
      String str = num.substring(begin, begin + 2);
      if (Integer.parseInt(str) <= 25) {
        int i = Integer.parseInt(str);
        backTrack(num, begin + 2, temp + Utils.getChar(i), result);
      }
    }
  }
}
