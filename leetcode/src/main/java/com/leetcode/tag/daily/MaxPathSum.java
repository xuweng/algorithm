package com.leetcode.tag.daily;

/**
 * 搞懂题目
 *
 * <p>搞懂示例
 *
 * <p>搞懂题目
 *
 * <p>搞懂示例
 *
 * <p>遍历。穷举。遍历。穷举。遍历。穷举。遍历。穷举。遍历。穷举。穷举。遍历。遍历。穷举。
 *
 * <p>124. 二叉树中的最大路径和
 */
public class MaxPathSum {
  private int result = Integer.MIN_VALUE;
  private int max = Integer.MIN_VALUE;
  TreeNode root;

  public int maxPathSum(TreeNode root) {
    pre(root);

    return result;
  }

  /**
   * 先序遍历
   *
   * <p>枚举所有结点，计算每个结点的最大路径
   *
   * @param treeNode
   */
  public void pre(TreeNode treeNode) {
    if (treeNode == null) {
      return;
    }
    // 入参为0才是正确的
    root = treeNode;
    preMax(treeNode, 0);
    result = Math.max(result, max);
    max = Integer.MIN_VALUE;
    pre(treeNode.left);
    pre(treeNode.right);
  }

  /**
   * 先序遍历
   *
   * <p>先序遍历
   *
   * <p>先序遍历
   *
   * <p>累加错误
   *
   * <p>累加错误
   *
   * <p>累加错误
   *
   * <p>只考虑当前root
   *
   * <p>只考虑当前root
   *
   * <p>子问题不能简单推导原问题
   *
   * <p>从root出发遍历每条路径
   *
   * <p>经过root结点
   *
   * <p>用子问题推导原问题
   *
   * <p>4个子问题?
   *
   * <p>单个root
   *
   * <p>左+treeNode
   *
   * <p>右+treeNode
   *
   * <p>左+treeNode+右
   *
   * @param treeNode
   * @return
   */
  private void preMax(TreeNode treeNode, int sum) {
    if (treeNode == null) {
      // 入参为0，越界一定要统计
      // 这里也要统计一次
      max = Math.max(max, sum);
      return;
    }
    // 当前是root
    // 这里加上root
    max = Math.max(max, sum + treeNode.val);
    preMax(treeNode.left, sum + treeNode.val);
    if (treeNode == root) {
      // 当前结点是root
      // 左子树的结果+右子树的结果
      preMax(treeNode.right, max);
    } else {
      preMax(treeNode.right, sum + treeNode.val);
    }
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
      maxGain(root);
      return maxSum;
    }

    /**
     * 二叉树路径问题
     *
     * <p>一开始:子问题直接推导原问题(原问题的路径没有包含子问题的路径)
     *
     * <p>搞错概念。搞错概念。搞错概念。搞错概念。搞错概念。搞错概念。搞错概念。搞错概念。搞错概念
     *
     * <p>两个不同的概念:答案、经过root的路径和
     *
     * <p>计算最大贡献值的同时计算答案
     *
     * <p>寻找路径。
     *
     * <p>路径。路径。路径。路径。路径。路径。
     *
     * <p>首先，考虑实现一个简化的函数 maxGain(node)，该函数计算二叉树中的一个节点的最大贡献值，具体而言，
     *
     * <p>就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
     *
     * <p>作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param node 以该节点为起点的一条路径
     * @return
     */
    public int maxGain(TreeNode node) {
      // 空节点的最大贡献值等于 0。
      if (node == null) {
        return 0;
      }

      // 递归计算左右子节点的最大贡献值
      // 只有在最大贡献值大于 0 时，才会选取对应子节点
      // 最大贡献值>=0
      int leftGain = Math.max(maxGain(node.left), 0);
      int rightGain = Math.max(maxGain(node.right), 0);

      // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
      // 4个子问题:root,left+root,right+root,left+root+right
      // 这里是:left+root+right
      // 4个子问题变成一个子问题
      int priceNewpath = node.val + leftGain + rightGain;

      // 更新答案
      maxSum = Math.max(maxSum, priceNewpath);

      // 非空节点的最大贡献值等于节点值与其子节点中的最大贡献值之和（对于叶节点而言，最大贡献值等于节点值）。
      // 返回节点的最大贡献值
      return node.val + Math.max(leftGain, rightGain);
    }
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
