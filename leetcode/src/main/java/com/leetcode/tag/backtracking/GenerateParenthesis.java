package com.leetcode.tag.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>递归树
 *
 * <p>22. 括号生成
 */
public class GenerateParenthesis {
  public List<String> generateParenthesis(int n) {
    return new ArrayList<>(re(n));
  }

  /**
   * 所有分支
   *
   * <p>所有子问题
   *
   * <p>分支好难想
   *
   * <p>子问题好难想
   *
   * @param temp
   * @param n
   */
  public void generateParenthesis1(List<String> list, int n) {
    for (int i = 0; i <= n; i++) {
      list.set(i, "()");
      generateParenthesis1(list, n - 1);
    }
  }

  /**
   * 就一个分支
   *
   * <p>就一个分支
   *
   * <p>就一个子问题
   *
   * <p>空间复杂度高
   *
   * <p>思路简单
   *
   * <p>老规矩
   *
   * <p>n-1-------------->n
   *
   * @param n
   * @return
   */
  public Set<String> re(int n) {
    if (n <= 1) {
      Set<String> result = new HashSet<>();
      result.add("()");

      return result;
    }

    // 就一个分支
    // 就一个子问题
    Set<String> set = re(n - 1);
    Set<String> result = new HashSet<>();
    if (set == null || set.isEmpty()) {
      return result;
    }
    for (String s : set) {
      result.add("()" + s);
      result.add(s + "()");
      for (int i = 0; i < s.length() - 1; i++) {
        // i和i+1插入一对括号
        result.add(s.substring(0, i + 1) + "()" + s.substring(i + 1));
      }
    }

    return result;
  }

  /** 我们可以生成所有 2^2n 个 '(' 和 ')' 字符构成的序列，然后我们检查每一个是否有效即可。 */
  class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> combinations = new ArrayList<>();
      generateAll(new char[2 * n], 0, combinations);
      return combinations;
    }

    /**
     * 每一位有两个选择
     *
     * <p>每一位是'('或者是')'
     *
     * @param current
     * @param pos
     * @param result
     */
    public void generateAll(char[] current, int pos, List<String> result) {
      if (pos == current.length) {
        if (valid(current)) {
          result.add(new String(current));
        }
      } else {
        // current[pos]有两个选择
        current[pos] = '(';
        generateAll(current, pos + 1, result);
        current[pos] = ')';
        generateAll(current, pos + 1, result);
      }
    }

    public boolean valid(char[] current) {
      int balance = 0;
      for (char c : current) {
        if (c == '(') {
          balance++;
        } else {
          balance--;
        }
        if (balance < 0) {
          return false;
        }
      }
      return (balance == 0);
    }
  }

  /**
   * 作者：liweiwei1419
   * 链接：https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public class Solution1 {
    // 做减法
    public List<String> generateParenthesis(int n) {
      List<String> res = new ArrayList<>();
      // 特判
      if (n == 0) {
        return res;
      }

      // 执行深度优先遍历，搜索可能的结果
      dfs("", n, n, res);
      return res;
    }

    /**
     * 递归树
     *
     * @param curStr 当前递归得到的结果
     * @param left 左括号还有几个可以使用
     * @param right 右括号还有几个可以使用
     * @param res 结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
      // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
      // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
      if (left == 0 && right == 0) {
        res.add(curStr);
        return;
      }

      // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）
      if (left > right) {
        return;
      }

      // 每个结点最多两个分支
      // 使用一个左括号
      if (left > 0) {
        dfs(curStr + "(", left - 1, right, res);
      }
      // 使用一个右括号
      if (right > 0) {
        dfs(curStr + ")", left, right - 1, res);
      }
    }
  }

  /**
   * 作者：liweiwei1419
   * 链接：https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public class Solution2 {
    // 做加法
    public List<String> generateParenthesis(int n) {
      List<String> res = new ArrayList<>();
      // 特判
      if (n == 0) {
        return res;
      }

      dfs("", 0, 0, n, res);
      return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left 左括号已经用了几个
     * @param right 右括号已经用了几个
     * @param n 左括号、右括号一共得用几个
     * @param res 结果集
     */
    private void dfs(String curStr, int left, int right, int n, List<String> res) {
      if (left == n && right == n) {
        res.add(curStr);
        return;
      }

      // 剪枝
      if (left < right) {
        return;
      }

      if (left < n) {
        dfs(curStr + "(", left + 1, right, n, res);
      }
      if (right < n) {
        dfs(curStr + ")", left, right + 1, n, res);
      }
    }
  }

  /**
   * 作者：liweiwei1419
   * 链接：https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public class Solution3 {
    /**
     * 把结果集保存在动态规划的数组里
     *
     * <p>定义状态 dp[i]：使用 i 对括号能够生成的组合。
     *
     * <p>状态转移方程是：
     *
     * <p>dp[i] = "(" + dp[可能的括号对数] + ")" + dp[剩下的括号对数]
     *
     * <p>dp[i] = "(" + dp[j] + ")" + dp[i- j - 1] , j = 0, 1, ..., i - 1
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
      if (n == 0) {
        return new ArrayList<>();
      }
      // 这里 dp 数组我们把它变成列表的样子，方便调用而已
      List<List<String>> dp = new ArrayList<>(n);

      List<String> dp0 = new ArrayList<>();
      dp0.add("");
      dp.add(dp0);

      for (int i = 1; i <= n; i++) {
        List<String> cur = new ArrayList<>();
        for (int j = 0; j < i; j++) {
          List<String> str1 = dp.get(j);
          List<String> str2 = dp.get(i - 1 - j);
          for (String s1 : str1) {
            for (String s2 : str2) {
              // 枚举右括号的位置
              cur.add("(" + s1 + ")" + s2);
            }
          }
        }
        dp.add(cur);
      }
      return dp.get(n);
    }
  }
}
