package com.leetcode.tag.recursive;

/**
 * 根据原问题定义递归.
 *
 * <p>小规模数据验证.
 *
 * <p>小规模数据验证.
 *
 * <p>小规模数据验证.
 *
 * <p>小规模数据验证.
 *
 * <p>根据原问题定义子问题.
 *
 * <p>面试题 17.12. BiNode
 */
public class s1712 {
  /**
   * 确定链表的开始位置和结束位置.
   *
   * <p>左子树最大值,右子树最小值
   *
   * <p>整个树变成单链表,并且返回头结点
   *
   * <p>左右子树求值不一样
   *
   * @param root
   * @return
   */
  public TreeNode convertBiNode(TreeNode root) {
    // 根结点为null.当前层考虑
    if (root == null) {
      return null;
    }
    // 叶子结点.当前层考虑
    if (root.left == null && root.right == null) {
      return root;
    }
    // 保存左子树最右结点
    TreeNode j = jie(root.left);
    // 左子树变成单链表,并且返回头结点
    TreeNode l = convertBiNode(root.left);
    // 右子树变成单链表,并且返回头结点
    TreeNode r = convertBiNode(root.right);
    if (j != null) {
      j.right = root;
      j.left = null;
    }
    root.right = r;
    root.left = null;
    if (l != null) {
      l.left = null;
    }
    if (r != null) {
      r.left = null;
    }

    // 小数据
    return (l == null) ? root : l;
  }

  public TreeNode jie(TreeNode node) {
    if (node == null) {
      return null;
    }
    if (node.right == null) {
      return node;
    }
    return jie(node.right);
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
