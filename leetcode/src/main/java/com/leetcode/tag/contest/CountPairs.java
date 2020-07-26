package com.leetcode.tag.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * 5474. 好叶子节点对的数量
 *
 * <p>二叉树的遍历
 *
 * <p>二叉树的遍历
 */
public class CountPairs {
  class Solution {
    List<TreeNode> list = new ArrayList<>();

    public int countPairs(TreeNode root, int distance) {
      if (root == null) {
        return 0;
      }
      zhong(root);

      for (int i = 0; i < list.size(); i++) {
        TreeNode treeNode = list.get(i);
        if (treeNode.left == null && treeNode.right == null) {
        }
      }
      return 0;
    }

    private void zhong(TreeNode root) {
      if (root == null) {
        return;
      }
      zhong(root.left);
      list.add(root);
      zhong(root.right);
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
