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

    hou(root, target);

    return (root != null && root.val == -1) ? null : root;
  }

  /**
   * 标记删除
   *
   * <p>这里要使用后序遍历。去掉parent参数。
   *
   * @param root
   * @param target
   */
  public void hou(TreeNode root, int target) {
    if (root == null) {
      return;
    }

    hou(root.left, target);
    hou(root.right, target);

    if (root.left != null && root.left.val == -1) {
      root.left = null;
    }
    if (root.right != null && root.right.val == -1) {
      root.right = null;
    }
    if (root.left == null && root.right == null && root.val == target) {
      // 只把引用改为null.引用的对象依然存在.我要把引用的对象删除。
      // 只能把引用改为null。不能直接删除引用的对象。
      root.val = -1;
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
