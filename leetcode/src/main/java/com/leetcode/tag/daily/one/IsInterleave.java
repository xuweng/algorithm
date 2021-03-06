package com.leetcode.tag.daily.one;

/**
 * 97. 交错字符串
 *
 * <p>计数dp
 *
 * <p>最优解dp
 *
 * <p>是否dp
 *
 * <p>接触了三种dp
 */
public class IsInterleave {
  /**
   * 思路与算法
   *
   * <p>双指针法?
   *
   * <p>dp
   *
   * <p>首先如果∣s1∣+∣s2∣​ =∣s3∣，那s3 ​必然不可能由 s1 s2 ​交错组成。在 ∣s1∣+∣s2∣=∣s3∣ 时
   *
   * <p>我们可以用动态规划来求解。我们定义 f(i,j) 表示 s1 的前 i个元素和 s2 ​的前 j 个元素是否能交错组成 s3 ​的前i+j 个元素。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/interleaving-string/solution/jiao-cuo-zi-fu-chuan-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      return true;
    }
  }

  /**
   * 不可能一下子就能找到答案.推理过程?推导过程?
   *
   * <p>看不懂题解，是因为没搞懂题目。没搞懂题目。
   *
   * <p>dp推理
   *
   * <p>dp推理
   *
   * <p>dp推理
   *
   * <p>dp推理
   *
   * <p>dp推理
   *
   * <p>状态定义:定义 f(i,j) 表示 s1 的前 i个元素和 s2 ​的前 j 个元素是否能交错组成 s3 ​的前i+j 个元素。
   *
   * <p>s3的前i+j。这样定义很巧妙。状态定义巧妙。状态定义巧妙。状态定义巧妙。状态定义巧妙。
   *
   * <p>状态方程类似。f(i-1)-------->f(i)
   *
   * <p>f(i,j) = [f(i−1,j) and s1(i) = s3(p)] or [f(i,j−1) and s2(j) = s3(p)]
   *
   * 其中p=i+j−1。边界条件为f(0,0)=True
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/interleaving-string/solution/jiao-cuo-zi-fu-chuan-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public boolean isInterleave(String s1, String s2, String s3) {
      int n = s1.length(), m = s2.length(), t = s3.length();

      // 这个容易理解
      if (n + m != t) {
        return false;
      }

      boolean[][] f = new boolean[n + 1][m + 1];

      f[0][0] = true;
      for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= m; ++j) {
          int p = i + j - 1;
          if (i > 0) {
            f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
          }
          if (j > 0) {
            f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
          }
        }
      }

      return f[n][m];
    }
  }

  /**
   * 使用滚动数组优化空间复杂度
   *
   * <p>熟悉的字符串，熟悉的动态规划，熟悉的滚动数组
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/interleaving-string/solution/jiao-cuo-zi-fu-chuan-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution2 {
    public boolean isInterleave(String s1, String s2, String s3) {
      int n = s1.length(), m = s2.length(), t = s3.length();

      if (n + m != t) {
        return false;
      }

      boolean[] f = new boolean[m + 1];

      f[0] = true;
      for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= m; ++j) {
          int p = i + j - 1;
          if (i > 0) {
            f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
          }
          if (j > 0) {
            f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
          }
        }
      }

      return f[m];
    }
  }
}
