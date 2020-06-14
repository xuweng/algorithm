package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 枚举所有的可能，不满足条件的就干掉
 *
 * <p>枚举所有可能，不满足条件的干掉
 *
 * <p>枚举所有可能，不满足条件的干掉
 *
 * <p>枚举所有可能，不满足条件干掉
 *
 * <p>枚举所有可能，不满足条件干掉
 *
 * <p>搞懂5个示例
 *
 * <p>搞懂5个示例
 *
 * <p>搞懂5个示例
 *
 * <p>搞懂5个示例
 *
 * <p>搞懂5个示例
 *
 * <p>搞懂5个示例
 *
 * <p>842. 将数组拆分成斐波那契序列
 */
public class SplitIntoFibonacci {
  public List<Integer> splitIntoFibonacci(String S) {
    if (S == null || S.length() == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> stack = new ArrayList<>();

    backTrack(S, 0, stack, result);

    return (result.size() > 0) ? result.get(0) : new ArrayList<>();
  }

  public void backTrack(String S, int start, List<Integer> stack, List<List<Integer>> result) {
    // 越界统计
    if (start >= S.length() && stack.size() >= 3 && isFibonacci(stack)) {
      result.add(new ArrayList<>(stack));
    }
    for (int i = start; i < S.length(); i++) {
      String s = S.substring(start, i + 1);
      if (s.length() > 1 && s.charAt(0) == '0') {
        continue;
      }
      try {
        stack.add(Integer.parseInt(s));
      } catch (NumberFormatException e) {
        return;
      }
      backTrack(S, i + 1, stack, result);
      stack.remove(stack.size() - 1);
    }
  }

  private boolean isFibonacci(List<Integer> result) {
    int pre1 = result.get(0);
    int pre2 = result.get(1);

    for (int i = 2; i < result.size(); i++) {
      if (pre1 + pre2 != result.get(i)) {
        return false;
      }
      pre1 = pre2;
      pre2 = result.get(i);
    }

    return true;
  }

  /**
   * 方法 1：暴力
   *
   * <p>作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/jiang-shu-zu-chai-fen-cheng-fei-bo-na-qi-xu-lie-by/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
      int N = S.length();
      for (int i = 0; i < Math.min(10, N); ++i) {
        if (S.charAt(0) == '0' && i > 0) {
          break;
        }
        long a = Long.parseLong(S.substring(0, i + 1));
        if (a >= Integer.MAX_VALUE) {
          break;
        }

        search:
        for (int j = i + 1; j < Math.min(i + 10, N); ++j) {
          if (S.charAt(i + 1) == '0' && j > i + 1) {
            break;
          }
          long b = Long.parseLong(S.substring(i + 1, j + 1));
          if (b >= Integer.MAX_VALUE) {
            break;
          }

          List<Integer> fib = new ArrayList<>();
          fib.add((int) a);
          fib.add((int) b);

          int k = j + 1;
          while (k < N) {
            long nxt = fib.get(fib.size() - 2) + fib.get(fib.size() - 1);
            String nxtS = String.valueOf(nxt);

            if (nxt <= Integer.MAX_VALUE && S.substring(k).startsWith(nxtS)) {
              k += nxtS.length();
              fib.add((int) nxt);
            } else {
              continue search;
            }
          }
          if (fib.size() >= 3) {
            return fib;
          }
        }
      }

      return new ArrayList<>();
    }
  }

  /**
   * 作者：jangbao
   * 链接：https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/solution/java-dfs-jia-jian-zhi-ji-bai-liao-9306-by-capta1n/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    List<Integer> ans;

    public List<Integer> splitIntoFibonacci(String S) {

      ans = new ArrayList<>();
      return dfs(0, S, 0, 0, 0) ? ans : new ArrayList<>();
    }

    /**
     * 用参数来计算
     *
     * <p>用参数来计算
     *
     * <p>用参数来计算
     *
     * @p : 当前指针指向数组的索引
     * @s : 字符串
     * @pre1 : 前面隔一个的数
     * @pre2 : 前一个数
     * @deep : 当前是第几个数
     */
    public boolean dfs(int p, String s, int pre1, int pre2, int deep) {
      int length = s.length();
      if (p == length) {
        return deep >= 3;
      }

      for (int i = 1; i <= 11; i++) {
        // 超出长度或者以0开头直接break;
        if (p + i > length || (s.charAt(p) == '0' && i > 1)) {
          break;
        }
        // 截取字符串
        String sub = s.substring(p, p + i);

        long numL = Long.parseLong(sub);
        // 判断是否超出范围,或者deep不是0,1却大于他的前两个数之和
        if (numL > Integer.MAX_VALUE || (deep != 0 && deep != 1 && numL > (pre1 + pre2))) {
          break;
        }
        // 转成int
        Integer num = (int) numL;
        // 满足条件的数,递归加回溯
        if (deep == 0 || deep == 1 || num.equals(pre1 + pre2)) {
          ans.add(num);
          if (dfs(p + i, s, pre2, num, deep + 1)) {
            return true;
          }
          ans.remove(num);
        }
      }
      return false;
    }
  }
}
