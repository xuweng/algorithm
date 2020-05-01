package com.leetcode.tag.recursive;

/**
 * 779. 第K个语法符号
 */
public class s779 {
  /**
   * 复杂度分析
   *
   * <p>时间复杂度： O(2^N)，其为生成字符串的总长度 2^0 + 2^1 + 2^{N-1}2 0 +2 1 +⋯+2 N−1 。
   *
   * <p>空间复杂度： O(2^N)，其为最后一行字符串的长度。
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/k-th-symbol-in-grammar/solution/di-kge-yu-fa-fu-hao-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param N
   * @param K
   * @return
   */
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
