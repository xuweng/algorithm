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

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
