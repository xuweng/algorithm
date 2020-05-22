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

  /**
   * 每个子问题用一个list保存,空间复杂度高
   *
   * <p>假设子问题解决
   *
   * <p>假设n-1解决,然后推导n
   *
   * @param digits
   * @param length
   * @return
   */
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

  class Solution {
    Map<String, String> phone =
            new HashMap<String, String>() {
              {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
              }
            };

    List<String> output = new ArrayList<>();

    /**
     * 从root到叶子结点的每条路径都用一个string保存
     *
     * <p>不能用一个string保存所有路径
     *
     * <p>用参数保存结果
     *
     * <p>用参数保存结果
     *
     * <p>从nextDigits挑选,保存到combination
     *
     * <p>只需要一个list保存结果.空间复杂度低
     *
     * <p>寻找所有分支
     *
     * <p>寻找所有子问题
     *
     * <p>递归解决所有分支
     *
     * <p>递归解决所有分支
     *
     * @param combination 每层的combination都是一个新对象
     * @param nextDigits
     */
    public void backtrack(String combination, String nextDigits) {
      // if there is no more digits to check
      if (nextDigits.length() == 0) {
        // the combination is done
        output.add(combination);
      }
      // if there are still digits to check
      else {
        // iterate over all letters which map
        // the next available digit
        String digit = nextDigits.substring(0, 1);
        String letters = phone.get(digit);
        for (int i = 0; i < letters.length(); i++) {
          String letter = phone.get(digit).substring(i, i + 1);
          // append the current letter to the combination
          // and proceed to the next digits
          backtrack(combination + letter, nextDigits.substring(1));
        }
      }
    }

    public List<String> letterCombinations(String digits) {
      if (digits.length() != 0) {
        backtrack("", digits);
      }
      return output;
    }
  }

  class Solution2 {
    private String letterMap[] = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };
    private List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
      if (digits.length() == 0) {
        return new ArrayList<>();
      }
      dfs(digits, 0, new StringBuilder());
      return ans;
    }

    /**
     * 因为StringBuilder传入的都是同一个对象，所以在递归完成之后必须撤回上一次的操作，
     *
     * <p>需要删除上一次添加的字符。而String每次改变之后传入的都是不同的对象。故无需撤销操作。
     *
     * @param digits
     * @param start
     * @param path
     */
    private void dfs(String digits, int start, StringBuilder path) {
      if (start == digits.length()) {
        ans.add(path.toString());
        return;
      }
      char c = digits.charAt(start);
      String letter = letterMap[c - '0'];
      for (int i = 0; i < letter.length(); i++) {
        // 保存递归前的长度
        int len = path.length();
        // 递归一个分支
        dfs(digits, start + 1, path.append(letter.charAt(i)));
        // 递归分支结束后的长度.从root到叶子结点
        // 删除递归这条分支保存的结果,然后开始递归下一个分支
        path.delete(len, path.length());
      }
    }
  }
}
