package com.leetcode.tag.daily;

/**
 * 1028. 从先序遍历还原二叉树
 */
public class RecoverFromPreorder {
  private int[] getIndex(String s, String token) {
    char[] chars = s.toCharArray();
    int preIndex = chars.length - 1;
    for (int i = chars.length - 2; i >= 0; i--) {
      if (Character.isDigit(chars[i])) {
        if (token.equals(s.substring(i + 1, preIndex))) {
          return new int[]{i, preIndex};
        }
        preIndex = i;
      }
    }
    return null;
  }

  class Solution {
    public TreeNode recoverFromPreorder(String S) {
      return re(S, "-");
    }

    public TreeNode re(String S, String token) {
      int root = Integer.parseInt(String.valueOf(S.charAt(0)));
      int[] indexes = getIndex(S, token);
      if (indexes == null) {
        return null;
      }
      int index = S.indexOf(token);
      int lastIndex = S.lastIndexOf(token);
      if (index == -1 || lastIndex == -1) {
        return null;
      }
      TreeNode treeNode = new TreeNode(root);
      treeNode.left = re(S.substring(1 + token.length(), indexes[0]), token + "-");
      treeNode.right = re(S.substring(indexes[1]), token + "-");

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
