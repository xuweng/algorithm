package com.leetcode.tag.divide;

import java.util.ArrayList;
import java.util.List;

/**
 * 十分钟没有思路看答案
 *
 * <p>十分钟没有思路看答案
 *
 * <p>十分钟没有思路看答案
 *
 * <p>十分钟没有思路看答案
 *
 * <p>明确问题
 *
 * <p>明确问题
 *
 * <p>添加括号和求值
 *
 * <p>结果只需要求值
 *
 * <p>常规分治?常规分治?
 *
 * <p>f(n)--------->f(n-1).这样划分目测很麻烦?
 *
 * <p>f(n)------------>f(n/2).这样划分?
 *
 * <p>f(n)---------->f(1)、f(2)、f(3)...........f(n-1)这样划分?
 *
 * <p>怎么划分子问题?
 *
 * <p>241. 为运算表达式设计优先级
 */
public class DiffWaysToCompute {

  public List<Integer> diffWaysToCompute(String input) {
    return re(input, 0, input.length() - 1);
  }

  /**
   * 左右划分
   *
   * <p>不是按照mid划分
   *
   * <p>是按照运算符划分
   *
   * <p>一看到题就觉得有点复杂，可以考虑一下递归的方式，去寻找子问题和原问题解的关系。
   *
   * <p>可以通过运算符把整个式子分成两部分，两部分再利用递归解决。
   *
   * <p>作者：windliang
   * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-5/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param input
   * @return
   */
  public List<Integer> re(String input, int low, int high) {
    if (input == null || input.length() == 0 || low > high) {
      return new ArrayList<>();
    }
    // 考虑当前层
    // 当前层:low---->high
    // 当前层:root
    List<Integer> result = new ArrayList<>();
    if (low == high) {
      result.add(Integer.valueOf(String.valueOf(input.charAt(low))));
      return result;
    }

    for (int i = low; i <= high; i++) {
      // 通过运算符将字符串分成两部分
      if (!isOperation(input.charAt(i))) {
        continue;
      }
      List<Integer> left = re(input, low, i - 1);
      List<Integer> right = re(input, i + 1, high);
      // 将两个结果依次运算
      for (Integer l : left) {
        for (Integer r : right) {
          result.add(caculate(l, input.charAt(i), r));
        }
      }
    }
    return result;
  }

  private int caculate(int num1, char c, int num2) {
    if (c == '+') {
      return num1 + num2;
    } else if (c == '-') {
      return num1 - num2;
    } else if (c == '*') {
      return num1 * num2;
    }
    return -1;
  }

  /**
   * 是否是运算符
   *
   * @param c
   * @return
   */
  private boolean isOperation(char c) {
    return c == '+' || c == '-' || c == '*';
  }
}
