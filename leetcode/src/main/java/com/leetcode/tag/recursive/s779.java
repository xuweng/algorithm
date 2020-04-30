package com.leetcode.tag.recursive;

/**
 * 779. 第K个语法符号
 */
public class s779 {
  public int kthGrammar(int N, int K) {
    String str = re(N);
    if (K > str.length()) {
      return -1;
    }
    return Integer.parseInt(Character.toString(str.charAt(K - 1)));
  }

  /**
   * 15 / 55 个通过测试用例 状态：超出内存限制 提交时间：0 分钟之前 最后执行的输入： 30 434991989
   *
   * @param n
   * @return
   */
  private String re(int n) {
    if (n <= 1) {
      return "0";
    }

    String str = re(n - 1);
    char[] array = str.toCharArray();
    StringBuilder result = new StringBuilder();
    for (char c : array) {
      String s = (c == '0') ? "01" : "10";
      result.append(s);
    }
    return result.toString();
  }
}
