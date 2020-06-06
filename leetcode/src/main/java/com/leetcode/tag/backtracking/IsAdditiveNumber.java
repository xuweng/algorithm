package com.leetcode.tag.backtracking;

/**
 * 写算法
 *
 * <p>先写一个框架,再补充细节
 *
 * <p>十分钟看答案
 *
 * <p>记住思路
 *
 * <p>十分钟看答案
 *
 * <p>记住思路
 *
 * <p>十分钟看答案
 *
 * <p>记住思路
 *
 * <p>十分钟看答案
 *
 * <p>记住思路
 *
 * <p>十分钟看答案
 *
 * <p>记住思路
 *
 * <p>306. 累加数
 */
public class IsAdditiveNumber {
  public boolean isAdditiveNumber(String num) {
    return backTrack(num, 0, 1);
  }

  public boolean backTrack(String num, int start, int count) {
    if (count >= num.length() - start - 1) {
      return false;
    }
    for (int i = start; i < num.length() - 2; i++) {
      int sum = Integer.parseInt(String.valueOf(num.charAt(i))) + get(num, i, count);
      int[] index = getIndex(num, sum, i, count);
      if (index[0] == -1) {
        continue;
      }
      return backTrack(num, i, count + 1);
    }
    return true;
  }

  public int get(String num, int start, int count) {
    return Integer.parseInt(num.substring(start + 1, start + count + 1));
  }

  public int[] getIndex(String num, int sum, int start, int count) {
    int index = -1;
    int value = -1;
    for (int i = start + count + 1; i < num.length(); i++) {
      int i1 = Integer.parseInt(num.substring(start + count + 1, i + 1));
      if (sum == i1) {
        index = i;
        value = i1;
      }
    }

    return new int[]{index, value};
  }

  public int[] getNum(String num, int start) {
    int[] nums = new int[num.length() - start];
    int index = 0;
    for (int i = start; i < num.length(); i++) {
      nums[index++] = Integer.parseInt(num.substring(start, i + 1));
    }

    return nums;
  }

  /**
   * 剪枝
   *
   * <p>剪枝。剪枝。剪枝。剪枝。剪枝。剪枝。剪枝。剪枝。剪枝。剪枝。剪枝。剪枝。剪枝
   *
   * <p>回溯。回溯。回溯。回溯。回溯。回溯。回溯。回溯
   *
   * <p>作者：rainlight
   * 链接：https://leetcode-cn.com/problems/additive-number/solution/javahui-su-100-by-rainlight/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public boolean isAdditiveNumber(String num) {
      return dfs(num, num.length(), 0, 0, 0, 0);
    }

    /**
     * 递归参数。递归参数。递归参数。递归参数
     *
     * <p>用参数统计
     *
     * @param num 原始字符串
     * @param len 原始字符串长度
     * @param idx 当前处理下标
     * @param sum 前面的两个数字之和
     * @param pre 前一个数字
     * @param k   当前是处理的第几个数字
     */
    private boolean dfs(String num, int len, int idx, long sum, long pre, int k) {
      if (idx == len) {
        return k > 2;
      }
      for (int i = idx; i < len; i++) {
        long cur = fetchCurValue(num, idx, i);
        // 剪枝：无效数字
        if (cur < 0) {
          continue;
        }
        // 剪枝：当前数字不等于前面两数之和
        if (k >= 2 && cur != sum) {
          continue;
        }
        // 注意这里结果返回
        if (dfs(num, len, i + 1, pre + cur, cur, k + 1)) {
          return true;
        }
      }
      return false;
    }

    /**
     * 获取 l ~ r 组成的有效数字
     */
    private long fetchCurValue(String num, int l, int r) {
      if (l < r && num.charAt(l) == '0') {
        return -1;
      }
      long res = 0;
      while (l <= r) {
        res = res * 10 + num.charAt(l++) - '0';
      }
      return res;
    }
  }
}
