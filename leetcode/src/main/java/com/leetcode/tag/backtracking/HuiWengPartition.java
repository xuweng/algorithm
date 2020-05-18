package com.leetcode.tag.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 许多复杂的，规模较大的问题都可以使用回溯法，有“通用解题方法”的美称。
 *
 * <p>回溯算法模板
 *
 * <p>求最优解太舒服了
 *
 * <p>求所有方案太难
 *
 * <p>所有方案?最优解?
 *
 * <p>所有可能的分割方案?
 *
 * <p>分割最少次数?
 *
 * <p>所有方案
 *
 * <p>分割最少次数?
 *
 * <p>不是求最优解
 *
 * <p>如何划分?
 *
 * <p>一次两两划分?
 *
 * <p>多次划分?
 *
 * <p>划分后需要递归?
 *
 * <p>131. 分割回文串
 *
 * <p>两两划分后,发现横跨mid的字符串就是原问题,横跨mid的字符串难求
 *
 * <p>能不能两两划分,就看能不能计算横跨mid这部分
 */
public class HuiWengPartition {
  public List<List<String>> partition(String s) {
    if (s == null) {
      return new ArrayList<>();
    }
    return re(s, 0, s.length() - 1);
  }

  public List<List<String>> re(String s, int low, int high) {
    if (low > high) {
      return null;
    }
    List<List<String>> lists = new ArrayList<>();
    if (low == high) {
      List<String> list = new ArrayList<>();
      list.add(s.substring(low, high + 1));
      lists.add(list);
      return lists;
    }
    for (int i = low; i < high; i++) {
      if (isHui(s, low, i)) {
        String left = s.substring(low, i + 1);
        List<List<String>> right = re(s, i + 1, high);
        for (List<String> list : right) {
          List<String> list1 = new ArrayList<>();
          list1.add(left);
          list1.addAll(list);
          lists.add(list1);
        }
      }
    }
    if (isHui(s, low, high)) {
      List<String> list = new ArrayList<>();
      list.add(s.substring(low, high + 1));
      lists.add(list);
    }

    return lists;
  }

  public boolean isHui(String s, int low, int high) {
    if (s == null || low > high) {
      return false;
    }
    // 递归终止条件
    if (low == high) {
      return true;
    }
    boolean b = s.charAt(low) == s.charAt(high);
    if (high - low == 1) {
      return b;
    }

    return b && isHui(s, low + 1, high - 1);
  }

  class Solution {
    private List<String> temp = new ArrayList<>();
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
      char[] chars = s.toCharArray();
      dopart(chars, 0, chars.length - 1);
      return res;
    }

    public void dopart(char[] chars, int i, int j) {
      if (i > j) {
        res.add(new ArrayList<>(temp));
        return;
      }
      for (int k = i; k <= j; k++) {
        if (isPalindrome(chars, i, k)) {
          temp.add(new String(chars, i, k - i + 1));
          dopart(chars, k + 1, j);
          temp.remove(temp.size() - 1);
        }
      }
    }

    /**
     * 是否是回文
     *
     * @param chars
     * @param i
     * @param j
     * @return
     */
    public boolean isPalindrome(char[] chars, int i, int j) {
      if (i == j) {
        return true;
      }
      while (i <= j) {
        if (chars[i] != chars[j]) {
          return false;
        }
        i++;
        j--;
      }
      return true;
    }
  }

  /**
   * 字符串当成一个结点
   *
   * <p>字符串------------结点
   *
   * <p>数字--------------结点
   *
   * <p>递归树
   *
   * <p>递归树
   *
   * <p>递归树
   *
   * <p>搜索问题主要使用回溯法。
   *
   * <p>回溯法思考的步骤：
   *
   * <p>1、画递归树；
   *
   * <p>2、根据自己画的递归树编码。 作者：liweiwei1419
   * 链接：https://leetcode-cn.com/problems/palindrome-partitioning/solution/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    List<List<String>> res = new ArrayList<>();
    // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
    // 注意：只使用 stack 相关的接口
    Deque<String> stack = new ArrayDeque<>();

    public List<List<String>> partition(String s) {
      int len = s.length();
      if (len == 0) {
        return res;
      }

      backtracking(s, 0, len);
      return res;
    }

    /**
     * 图遍历
     *
     * <p>图遍历
     *
     * <p>多叉树遍历
     *
     * <p>遍历.遍历.遍历
     *
     * @param s
     * @param start 起始字符的索引
     * @param len   字符串 s 的长度，可以设置为全局变量
     * @param path  记录从根结点到叶子结点的路径
     * @param res   记录所有的结果
     */
    private void backtracking(String s, int start, int len) {
      if (start == len) {
        res.add(new ArrayList<>(stack));
        return;
      }

      for (int i = start; i < len; i++) {
        // 因为截取字符串是消耗性能的，因此，采用传子串索引的方式判断一个子串是否是回文子串
        // 不是的话，剪枝
        if (!checkPalindrome(s, start, i)) {
          continue;
        }

        // 保存截取的字符串
        stack.addLast(s.substring(start, i + 1));
        backtracking(s, i + 1, len);
        stack.removeLast();
      }
    }

    /**
     * 这一步的时间复杂度是 O(N)，因此，可以采用动态规划先把回文子串的结果记录在一个表格里
     *
     * @param str
     * @param left 子串的左边界，可以取到
     * @param right 子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(String str, int left, int right) {
      // 严格小于即可
      while (left < right) {
        if (str.charAt(left) != str.charAt(right)) {
          return false;
        }
        left++;
        right--;
      }
      return true;
    }
  }
}
