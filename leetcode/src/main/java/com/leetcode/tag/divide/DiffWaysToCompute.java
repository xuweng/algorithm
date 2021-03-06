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
   * 通过下标控制.通过下标计算.通过下标计算
   *
   * <p>注意下标
   *
   * <p>左右划分
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
    //    if (low == high) {
    //      result.add(Integer.valueOf(String.valueOf(input.charAt(low))));
    //      return result;
    //    }

    int count = 0;
    for (int i = low; i <= high; i++) {
      // 通过运算符将字符串分成两部分
      if (!isOperation(input.charAt(i))) {
        // 不是运算符
        count++;
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
    // 如果给定的字符串只有数字，没有运算符，那结果就是给定的字符串转为数字。
    if (count == high - low + 1) {
      result.add(Integer.valueOf(input.substring(low, high + 1)));
    }

    return result;
  }

  /**
   * 最巧妙的地方就是做一个预处理，把每个数字提前转为 int 然后存起来，同时把运算符也都存起来。
   *
   * <p>这样的话我们就有了两个 list，一个保存了所有数字，一个保存了所有运算符。
   *
   * <p>dp[i][j] 也比较好定义了，含义是第 i 到第 j 个数字（从 0 开始计数）范围内的表达式的所有解。
   *
   * <p>作者：windliang
   * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-5/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param input
   * @return
   */
  public List<Integer> dp(String input) {
    List<Integer> numList = new ArrayList<>();
    List<Character> opList = new ArrayList<>();
    char[] array = input.toCharArray();
    int num = 0;
    for (char c : array) {
      if (isOperation(c)) {
        numList.add(num);
        num = 0;
        opList.add(c);
        continue;
      }
      num = num * 10 + c - '0';
    }
    numList.add(num);
    int N = numList.size(); // 数字的个数

    // 一个数字
    ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];
    for (int i = 0; i < N; i++) {
      ArrayList<Integer> result = new ArrayList<>();
      result.add(numList.get(i));
      dp[i][i] = result;
    }
    // 2 个数字到 N 个数字
    for (int n = 2; n <= N; n++) {
      // 开始下标
      for (int i = 0; i < N; i++) {
        // 结束下标
        int j = i + n - 1;
        if (j >= N) {
          break;
        }
        ArrayList<Integer> result = new ArrayList<>();
        // 分成 i ~ s 和 s+1 ~ j 两部分
        for (int s = i; s < j; s++) {
          ArrayList<Integer> result1 = dp[i][s];
          ArrayList<Integer> result2 = dp[s + 1][j];
          for (Integer integer : result1) {
            for (Integer value : result2) {
              // 第 s 个数字下标对应是第 s 个运算符
              char op = opList.get(s);
              result.add(caculate(integer, op, value));
            }
          }
        }
        dp[i][j] = result;
      }
    }
    return dp[0][N - 1];
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
