package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 */
public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    zhong(root, list);

    return isSort(list);
  }

  /**
   * 是否升序
   *
   * @param list
   * @return
   */
  public boolean isSort(List<Integer> list) {
    if (list == null) {
      return false;
    }
    if (list.isEmpty()) {
      return true;
    }
    if (list.size() == 1) {
      return true;
    }
    int max = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) <= max) {
        return false;
      }
      max = list.get(i);
    }

    return true;
  }

  public void zhong(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    // 先左子树放入list
    zhong(root.left, list);
    // root放入list
    list.add(root.val);
    // 后右子树放入list
    zhong(root.right, list);
  }

  /**
   * 判断是否bst
   *
   * <p>递归
   *
   * @param root
   */
  public boolean re(TreeNode root) {
    if (root == null) {
      return true;
    }
    // 叶子结点
    if (root.left == null && root.right == null) {
      return true;
    }
    TreeNode left = jieLeft(root.left);
    TreeNode right = jieRight(root.right);
    boolean l = (left == null) || (left.val < root.val);
    boolean r = (right == null) || (right.val > root.val);

    boolean c = re(root.left) && re(root.right);

    return c & l & r;
  }

  public TreeNode jieLeft(TreeNode root) {
    if (root == null) {
      return null;
    }
    // 叶子结点
    if (root.right == null) {
      return root;
    }
    return jieLeft(root.right);
  }

  public TreeNode jieRight(TreeNode root) {
    if (root == null) {
      return null;
    }
    // 叶子结点
    if (root.left == null) {
      return root;
    }
    return jieLeft(root.left);
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
