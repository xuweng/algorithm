package com.leetcode.tag.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 */
public class SerializeAndDeserializeBinaryTree {
  class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if (root == null) {
        return "";
      }
      StringBuilder stringBuilder = new StringBuilder();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.poll();
          if (node.val != Integer.MAX_VALUE) {
            stringBuilder.append(node.val);
          } else {
            // 最后一层不需要加上
            stringBuilder.append("null");
          }
          stringBuilder.append(",");
          if (node.left == null) {
            queue.add(new TreeNode(Integer.MAX_VALUE));
          } else {
            if (node.left.val != Integer.MAX_VALUE) {
              queue.add(node.left);
            }
          }
          if (node.right == null) {
            queue.add(new TreeNode(Integer.MAX_VALUE));
          } else {
            if (node.right.val != Integer.MAX_VALUE) {
              queue.add(node.right);
            }
          }
        }
      }

      return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      return null;
    }
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
