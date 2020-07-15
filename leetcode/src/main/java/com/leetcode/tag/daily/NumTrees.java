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
   *
   * <p>对于树，我有想到递归，想到左子树和右子树
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
     * 给定序列1⋯n，我们选择数字 i 作为根，则根为 i 的所有二叉搜索树的集合是左子树集合和右子树集合的笛卡尔积
     *
     * <p>举例而言，创建以 3 为根、长度为 7 的不同二叉搜索树，整个序列是 [1,2,3,4,5,6,7]，
     *
     * <p>我们需要从左子序列[1,2] 构建左子树，从右子序列 [4,5,6,7] 构建右子树，然后将它们组合（即笛卡尔积）。
     *
     * <p>对于这个例子，不同二叉搜索树的个数为F(3,7)。我们将 [1,2] 构建不同左子树的数量表示为G(2),
     *
     * <p>从 [4,5,6,7] 构建不同右子树的数量表示为G(4)，注意到G(n) 和序列的内容无关，只和序列的长度有关。
     *
     * <p>于是F(3,7)=G(2)⋅G(4)。
     *
     * <p>题目要求是计算不同二叉搜索树的个数。为此，我们可以定义两个函数：
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
