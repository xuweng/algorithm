package com.leetcode.tag.backtracking.one;

import java.util.*;

/**
 * 阅读优秀代码
 *
 * <p>阅读优秀代码
 *
 * <p>阅读优秀代码
 *
 * <p>阅读优秀代码
 *
 * <p>阅读优秀代码
 *
 * <p>93. 复原IP地址
 */
public class RestoreIpAddresses {
  public List<String> restoreIpAddresses(String s) {
    return null;
  }

  /**
   * 作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/fu-yuan-ipdi-zhi-by-leetcode/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<String>();
    ArrayList<String> output = new ArrayList<String>();

    /**
     * Check if the current segment is valid :
     *
     * <p>1. less or equal to 255
     *
     * <p>2. the first character could
     *
     * <p>be '0' only if the segment is equal to '0'
     *
     * @param segment
     * @return
     */
    public boolean valid(String segment) {
      int m = segment.length();
      if (m > 3) {
        return false;
      }
      return (segment.charAt(0) != '0') ? (Integer.parseInt(segment) <= 255) : (m == 1);
    }

    /**
     * Append the current list of segments to the list of solutions
     *
     * @param currPos
     */
    public void updateOutput(int currPos) {
      String segment = s.substring(currPos + 1, n);
      if (valid(segment)) {
        segments.add(segment);
        output.add(String.join(".", segments));
        segments.removeLast();
      }
    }

    /**
     * 枚举3个点放置的位置
     *
     * <p>prevpos : the position of the previously placed dot dots : number of dots to place
     *
     * @param prevpos 该函数使用上一个放置的点
     * @param dots    待放置点的数量
     */
    public void backtrack(int prevpos, int dots) {
      // The current dot curr_pos could be placed
      // in a range from prevpos + 1 to prevpos + 4.
      // The dot couldn't be placed
      // after the last character in the string.
      int maxPos = Math.min(n - 1, prevpos + 4);
      for (int currPos = prevpos + 1; currPos < maxPos; currPos++) {
        String segment = s.substring(prevpos + 1, currPos + 1);
        if (!valid(segment)) {
          continue;
        }
        // place dot
        segments.add(segment);
        if (dots - 1 == 0) {
          // if all 3 dots are placed
          // add the solution to output
          updateOutput(currPos);
        } else {
          // continue to place dots
          backtrack(currPos, dots - 1);
        }
        // remove the last placed dot
        segments.removeLast();
      }
    }

    public List<String> restoreIpAddresses(String s) {
      n = s.length();
      this.s = s;
      backtrack(-1, 3);
      return output;
    }
  }

  /**
   * 思路清晰。容易看懂
   *
   * <p>就学这个
   *
   * <p>作者：liweiwei1419 *
   * 链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/
   * * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 *
   */
  class Solution1 {
    public List<String> restoreIpAddresses(String s) {
      int len = s.length();
      List<String> res = new ArrayList<>();
      // 如果长度不够，不搜索
      if (len < 4 || len > 12) {
        return res;
      }

      Deque<String> path = new ArrayDeque<>(4);
      int splitTimes = 0;
      dfs(s, len, splitTimes, 0, path, res);
      return res;
    }

    /**
     * 判断 s 的子区间 [left, right] 是否能够成为一个 ip 段 判断的同时顺便把类型转了
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int judgeIfIpSegment(String s, int left, int right) {
      int len = right - left + 1;

      // 大于 1 位的时候，不能以 0 开头
      if (len > 1 && s.charAt(left) == '0') {
        return -1;
      }

      // 转成 int 类型
      int res = 0;
      for (int i = left; i <= right; i++) {
        res = res * 10 + s.charAt(i) - '0';
      }

      if (res > 255) {
        return -1;
      }
      return res;
    }

    /**
     * 每次选择一个数
     *
     * <p>每次选择一个子串
     *
     * @param s
     * @param len
     * @param split
     * @param begin
     * @param path
     * @param res
     */
    private void dfs(
            String s, int len, int split, int begin, Deque<String> path, List<String> res) {
      if (begin == len) {
        if (split == 4) {
          res.add(String.join(".", path));
        }
        return;
      }

      // 看到剩下的不够了，就退出（剪枝），len - begin 表示剩余的还未分割的字符串的位数
      if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) {
        return;
      }

      // 候选集
      // 每个begin有3个长度可以选择。1,2,3
      for (int i = 0; i < 3; i++) {
        if (begin + i >= len) {
          break;
        }

        int ipSegment = judgeIfIpSegment(s, begin, begin + i);
        if (ipSegment != -1) {
          // 选择一个子串
          // 在判断是 ip 段的情况下，才去做截取
          path.addLast(ipSegment + "");
          dfs(s, len, split + 1, begin + i + 1, path, res);
          path.removeLast();
        }
      }
    }
  }
}
