package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 */
public class LetterCombinations {
  Map<Character, String> map;

  public List<String> letterCombinations(String digits) {
    init();

    if (digits == null || digits.isEmpty()) {
      return new ArrayList<>();
    }

    return re(digits, digits.length() - 1);
  }

  public List<String> re(String digits, int length) {
    if (length < 0) {
      return new ArrayList<>();
    }
    if (length == 0) {
      String str = map.getOrDefault(digits.charAt(length), "");
      List<String> list = new ArrayList<>();
      for (int i = 0; i < str.length(); i++) {
        list.add(String.valueOf(str.charAt(i)));
      }
      return list;
    }

    List<String> list = re(digits, length - 1);
    if (list == null) {
      return new ArrayList<>();
    }
    List<String> stringList = new ArrayList<>();
    String characters = map.getOrDefault(digits.charAt(length), "");
    for (String s : list) {
      for (int i = 0; i < characters.length(); i++) {
        stringList.add(s + characters.charAt(i));
      }
    }

    return stringList;
  }

  private void init() {
    map = new HashMap<>();

    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
  }
}
