package com.leetcode.tag.daily;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildBinaryTree {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
      return null;
    }
    return re(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  /**
   * 找到所有分支
   *
   * <p>找到所有子问题
   *
   * <p>找到所有分支
   *
   * <p>找到所有子问题
   *
   * <p>找到所有子问题
   *
   * <p>找到所有分支
   *
   * @param preOrder
   * @param pI
   * @param pJ
   * @param inOrder
   * @param iI
   * @param iJ
   * @return
   */
  public TreeNode re(int[] preOrder, int pI, int pJ, int[] inOrder, int iI, int iJ) {
    if (pI > pJ || iI > iJ) {
      return null;
    }
    int root = preOrder[pI];

    // 中序root下标
    int i = iI;
    while (i <= iJ && root != inOrder[i]) {
      i++;
    }
    int leftCount = i - iI;
    TreeNode left = re(preOrder, pI + 1, pI + leftCount, inOrder, iI, i - 1);
    TreeNode right = re(preOrder, pI + leftCount + 1, pJ, inOrder, i + 1, iJ);
    TreeNode treeNode = new TreeNode(root);
    treeNode.left = left;
    treeNode.right = right;

    return treeNode;
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
