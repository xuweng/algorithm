package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. 二叉树的层序遍历
 *
 * <p>子问题依赖和子问题重复不一样
 *
 * <p>子问题依赖是递归同一层的问题相互依赖.子问题重复不是在递归同一层
 */
public class BinaryTreeLevelOrderTraversal {
  /**
   * 用递归明显不对.左子树与右子树依赖
   *
   * <p>左子树.右子树.左子树和右子树依赖.子问题相互依赖
   *
   * <p>递归做的事太多
   *
   * <p>递归在同一层
   *
   * <p>递归只做一件事
   *
   * <p>是左子树,不是一个左结点
   *
   * <p>是右子树,不是一个右结点
   *
   * @param root
   * @param height
   * @param lists
   */
  public void levelOrder(TreeNode root, int height, List<List<Integer>> lists) {
    if (height == 0) {
      return;
    }
    List<Integer> list = new ArrayList<>();
    list.add(root.val);
    lists.add(list);
    levelOrder(root.left, height - 1, lists);
    levelOrder(root.right, height - 1, lists);
  }

  /**
   * 高度
   *
   * @param root
   * @return
   */
  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(height(root.left), height(root.right)) + 1;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
