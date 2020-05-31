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
      return true;
    }

    List<List<Integer>> result = new ArrayList<>();

    levels(0, root, result);

    for (List<Integer> list : result) {
      int low = 0, high = list.size() - 1;
      while (low < high) {
        if (list.get(low) != (list.get(high))) {
          return false;
        }
        low++;
        high--;
      }
    }

    return true;
  }

  /**
   * 中序遍历不对
   *
   * @param root
   * @param result
   */
  public void levels(int level, TreeNode root, List<List<Integer>> result) {
    if (level == result.size()) {
      result.add(new ArrayList<>());
    }
    if (root == null) {
      result.get(level).add(null);
      return;
    }
    if (root.left == null && root.right == null) {
      result.get(level).add(root.val);
      return;
    }
    result.get(level).add(root.val);
    levels(level + 1, root.left, result);
    levels(level + 1, root.right, result);
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
