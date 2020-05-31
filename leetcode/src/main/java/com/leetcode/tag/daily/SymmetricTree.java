package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
  /**
   * 假设求左子树是否对称，求右子树是否对称。没什么用。
   *
   * <p>左子树，右子树两个子问题。先搞定左子树，然后搞定右子树。
   *
   * <p>同时依赖左子树和右子树。子问题依赖。子问题不独立。
   *
   * @param root
   * @return
   */
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return false;
    }

    List<Integer> result = new ArrayList<>();
    zhong(root, result);

    int low = 0, high = result.size() - 1;
    while (low < high) {
      if (result.get(low) != (result.get(high))) {
        return false;
      }
      low++;
      high--;
    }

    return true;
  }

  public void zhong(TreeNode root, List<Integer> result) {
    if (root.left == null && root.right == null) {
      result.add(root.val);
      return;
    }
    if (root.left == null || root.right == null) {
      result.add(null);
      return;
    }
    zhong(root.left, result);
    result.add(root.val);
    zhong(root.right, result);
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
