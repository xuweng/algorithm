package com.leetcode.tag.backtracking.one;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>89. 格雷编码
 */
public class GrayCode {
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    backTrack(n, "", result);

    return result;
  }

  /**
   * 没搞懂题目
   *
   * @param n
   * @param temp
   * @param result
   */
  public void backTrack(int n, String temp, List<Integer> result) {
    if (n == 0) {
      result.add(Integer.parseInt(temp, 2));
      return;
    }
    for (int i = 0; i <= 1; i++) {
      backTrack(n - 1, temp + i, result);
    }
  }

  /**
   * 作者：jyd
   * 链接：https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public List<Integer> grayCode(int n) {
      List<Integer> res =
              new ArrayList<Integer>() {
                {
                  add(0);
                }
              };
      int head = 1;
      for (int i = 0; i < n; i++) {
        for (int j = res.size() - 1; j >= 0; j--) {
          res.add(head + res.get(j));
        }
        head <<= 1;
      }
      return res;
    }
  }

  /**
   * 规律题目
   *
   * <p>技巧性题目
   *
   * <p>作者：windliang
   * 链接：https://leetcode-cn.com/problems/gray-code/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--12/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class S {
    /**
     * 解法一 动态规划
     *
     * <p>f(n-1)---------->f(n)
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
      List<Integer> gray = new ArrayList<>();
      gray.add(0); // 初始化 n = 0 的解
      for (int i = 0; i < n; i++) {
        int add = 1 << i; // 要加的数
        // 倒序遍历，并且加上一个值添加到结果中
        for (int j = gray.size() - 1; j >= 0; j--) {
          gray.add(gray.get(j) + add);
        }
      }
      return gray;
    }
  }
}
