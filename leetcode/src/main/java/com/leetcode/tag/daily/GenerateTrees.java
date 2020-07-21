package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
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
 */
public class GenerateTrees {
  /**
   * 二叉搜索树关键的性质是根节点的值大于左子树所有节点的值，小于右子树所有节点的值，且左子树和右子树也同样为二叉搜索树
   *
   * <p>如果我们枚举根节点的值为 i，那么根据二叉搜索树的性质我们可以知道左子树的节点值的集合为[1…i−1]，右子树的节点值的集合为 [i+1…n]
   */
  class Solution {
    public List<TreeNode> generateTrees(int n) {
      return null;
    }
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/bu-tong-de-er-cha-sou-suo-shu-ii-by-leetcode-solut/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public List<TreeNode> generateTrees(int n) {
      return n == 0 ? new LinkedList<>() : generateTrees(1, n);
    }

    /**
     * 递归只需要考虑当前层
     *
     * <p>递归只需要考虑当前层
     *
     * <p>递归只需要考虑当前层
     *
     * @param start
     * @param end
     * @return root结点集合
     */
    public List<TreeNode> generateTrees(int start, int end) {
      List<TreeNode> allTrees = new LinkedList<>();
      if (start > end) {
        allTrees.add(null);
        return allTrees;
      }

      // 枚举可行根节点
      for (int i = start; i <= end; i++) {
        // 获得所有可行的左子树集合
        List<TreeNode> leftTrees = generateTrees(start, i - 1);

        // 获得所有可行的右子树集合
        List<TreeNode> rightTrees = generateTrees(i + 1, end);

        // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
        for (TreeNode left : leftTrees) {
          for (TreeNode right : rightTrees) {
            TreeNode currTree = new TreeNode(i);
            currTree.left = left;
            currTree.right = right;
            allTrees.add(currTree);
          }
        }
      }
      return allTrees;
    }
  }

  /**
   * 换数据结构
   *
   * <p>换数据结构
   *
   * <p>换数据结构
   */
  class Solution2 {
    public List<TreeNode> generateTrees(int n) {
      return n == 0 ? new ArrayList<>() : generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int m, int n) {
      List<TreeNode> ans = new ArrayList<>();
      if (m > n) {
        ans.add(null);
        return ans;
      }
      for (int i = m; i <= n; i++) {
        List<TreeNode> left = generateTrees(m, i - 1);
        List<TreeNode> right = generateTrees(i + 1, n);
        for (TreeNode l : left) {
          for (TreeNode r : right) {
            TreeNode head = new TreeNode(i);
            head.left = l;
            head.right = r;
            ans.add(head);
          }
        }
      }
      return ans;
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
