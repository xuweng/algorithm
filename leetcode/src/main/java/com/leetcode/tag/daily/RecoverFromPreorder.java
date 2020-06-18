package com.leetcode.tag.daily;

/**
 * 1028. 从先序遍历还原二叉树
 */
public class RecoverFromPreorder {
  class Solution {
    public TreeNode recoverFromPreorder(String S) {
      return re(S, "-");
    }

    public TreeNode re(String S, String token) {
      int root = Integer.parseInt(String.valueOf(S.charAt(0)));
      int index = S.indexOf(token);
      int lastIndex = S.lastIndexOf(token);
      if (index == -1 || lastIndex == -1) {
        return null;
      }
      TreeNode treeNode = new TreeNode(root);
      treeNode.left = re(S.substring(index + 1, lastIndex), token + "-");
      treeNode.right = re(S.substring(lastIndex + 1), token + "-");

      return treeNode;
    }
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
