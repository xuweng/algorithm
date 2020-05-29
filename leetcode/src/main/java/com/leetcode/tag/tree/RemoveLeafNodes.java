package com.leetcode.tag.tree;

/**
 * 提交题解后，每道题目都有相关题目。可以尝试做相关题目。
 *
 * <p>原题目有5个示例。搞懂示例。
 *
 * <p>1325. 删除给定值的叶子节点
 */
public class RemoveLeafNodes {
  public TreeNode removeLeafNodes(TreeNode root, int target) {

    re(null, root, target);

    return root;
  }

  public void re(TreeNode parent, TreeNode root, int target) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      if (root.val != target) {
        return;
      }
      if (parent.left == root) {
        parent.left = null;
        root = parent;
      } else if (parent.right == root) {
        parent.right = null;
        root = parent;
      }
    }

    re(root, root.left, target);
    re(root, root.right, target);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
