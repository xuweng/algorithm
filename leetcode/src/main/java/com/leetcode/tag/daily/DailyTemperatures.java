package com.leetcode.tag.daily;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 数据结构
 *
 * <p>考查数据结构
 *
 * <p>739. 每日温度
 */
public class DailyTemperatures {
  public int[] dailyTemperatures(int[] T) {
    if (T == null || T.length == 0) {
      return new int[0];
    }
    int[] result = new int[T.length];
    result[T.length - 1] = 0;
    for (int i = 0; i < T.length - 1; i++) {
      int j = i;
      while (j < T.length && T[j] <= T[i]) {
        j++;
      }
      result[i] = (j >= T.length) ? 0 : j - i;
    }
    return result;
  }

  /**
   * 方法二：单调栈
   *
   * <p>单调递减栈
   *
   * <p>单调递减栈
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/daily-temperatures/solution/mei-ri-wen-du-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public int[] dailyTemperatures(int[] T) {
      int length = T.length;
      int[] ans = new int[length];
      Deque<Integer> stack = new LinkedList<>();
      for (int i = 0; i < length; i++) {
        int temperature = T[i];
        while (!stack.isEmpty() && temperature > T[stack.peek()]) {
          int prevIndex = stack.pop();
          ans[prevIndex] = i - prevIndex;
        }
        stack.push(i);
      }
      return ans;
    }
  }
}
