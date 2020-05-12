package com.leetcode.tag.divide;

/**
 * 面试题36. 二叉搜索树与双向链表
 */
public class TreeToDoublyList {
  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }
    Node head = re(root);
    Node hou = findHou(root);
    head.right = hou;
    hou.left = head;

    return head;
  }

  public Node re(Node root) {
    if (root == null) {
      return null;
    }
    Node left = re(root.left);
    Node right = re(root.right);
    root.right = right;
    if (right != null) {
      right.left = root;
    }
    // root前驱
    Node qian = findHou(root.left);
    if (qian != null) {
      qian.right = root;
    }
    root.left = qian;
    return (left == null) ? root : left;
  }

  public Node findQian(Node root) {
    if (root == null) {
      return null;
    }
    if (root.left == null) {
      return root;
    }
    return findQian(root.left);
  }

  public Node findHou(Node root) {
    if (root == null) {
      return null;
    }
    if (root.right == null) {
      return root;
    }
    return findHou(root.right);
  }

  class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
      val = _val;
      left = _left;
      right = _right;
    }
  }

  ;
}
