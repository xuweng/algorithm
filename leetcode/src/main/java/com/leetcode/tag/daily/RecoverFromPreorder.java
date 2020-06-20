package com.leetcode.tag.daily;

/**
 * 1028. 从先序遍历还原二叉树
 */
public class RecoverFromPreorder {
  static class Solution {
    public TreeNode recoverFromPreorder(String S) {
      return re(S, "-");
    }

    public TreeNode re(String S, String token) {
      if (S.length() <= 1) {
        // 叶子结点
        return new TreeNode(Integer.parseInt(S));
      }
      int index = getDigitIndex(S);
      int root = Integer.parseInt(S.substring(0, index + 1));
      int[] indexes = getIndex(S, token);
      TreeNode treeNode = new TreeNode(root);
      if (indexes == null) {
        treeNode.left = re(S.substring(index + token.length()), token + "-");
      } else {
        treeNode.left = re(S.substring(index + token.length(), indexes[0] + 1), token + "-");
        treeNode.right = re(S.substring(indexes[1]), token + "-");
      }

      return treeNode;
    }

    private int[] getIndex(String s, String token) {
      char[] chars = s.toCharArray();
      int preIndex = getDigitIndex(s) + token.length();
      String str = "";
      for (int i = preIndex; i < s.length(); i++) {
        if (!Character.isDigit(chars[i])) {
          str += chars[i];
        } else {
          if (str.equals(token)) {
            return new int[]{i - token.length() - 1, i};
          }
          str = "";
        }
      }

      return null;
    }

    private int getDigitIndex(String s) {
      char[] chars = s.toCharArray();
      String digit = "";
      for (int i = 0; i < s.length() && Character.isDigit(chars[i]); i++) {
        digit += chars[i];
      }

      return digit.length();
    }
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
