package com.leetcode.tag.daily;

/**
 * 96. 不同的二叉搜索树
 *
 * <p>思路和算法
 *
 * <p>思路和算法
 *
 * <p>思路和算法
 *
 * <p>通过示例找规律
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 *
 * <p>十分钟看答案
 */
public class NumTrees {
  /**
   * n=1?n=2?n=3......
   */
  class Solution {
    public int numTrees(int n) {
      return 0;
    }
  }

  /**
   * 十分钟没有思路就看题解，不要浪费时间
   *
   * <p>十分钟没有思路就看题解，不要浪费时间
   *
   * <p>十分钟没有思路就看题解，不要浪费时间
   *
   * <p>https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
   *
   * <p>给定一个有序序列 1⋯n，为了构建出一棵二叉搜索树，我们可以遍历每个数字 i，
   *
   * <p>将i作为树根，将1⋯(i−1) 序列作为左子树，将(i+1)⋯n 序列作为右子树。
   *
   * <p>1....(i-1),i,(i+1)...n
   *
   * <p>接着我们可以按照同样的方式递归构建左子树和右子树。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    /**
     * 题目要求是计算不同二叉搜索树的个数。为此，我们可以定义两个函数：
     *
     * <p>G(n): 长度为 n 的序列能构成的不同二叉搜索树的个数。
     *
     * <p>F(i,n): 以 i 为根、序列长度为 n 的不同二叉搜索树个数(1≤i≤n)。
     *
     * <p>可见，G(n) 是我们求解需要的函数。
     *
     * <p>状态定义：序列长度为n。
     *
     * <p>状态定义：序列长度为n。
     *
     * <p>状态定义：序列长度为n。
     *
     * <p>序列长度为n。序列长度为n。序列长度为n。序列长度为n。序列长度为n。序列长度为n。
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
      int[] G = new int[n + 1];
      G[0] = 1;
      G[1] = 1;

      for (int i = 2; i <= n; ++i) {
        for (int j = 1; j <= i; ++j) {
          G[i] += G[j - 1] * G[i - j];
        }
      }
      return G[n];
    }
  }
}
