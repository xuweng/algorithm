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

  /**
   * 递归逻辑思维顺序
   *
   * @param root
   * @return
   */
  public Node re(Node root) {
    if (root == null) {
      return null;
    }
    // root前驱
    Node qian = findHou(root.left);
    if (qian != null) {
      // 形成环
      qian.right = root;
    }
    Node left = re(root.left);
    Node right = re(root.right);
    root.right = right;
    if (right != null) {
      right.left = root;
    }
    root.left = qian;
    return (left == null) ? root : left;
  }

  public Node findQian(Node root) {
    if (root == null || root.left == null) {
      return root;
    }
    return findQian(root.left);
  }

  /**
   * java.lang.StackOverflowError
   *
   * @param root
   * @return
   */
  public Node findHou(Node root) {
    if (root == null || root.right == null) {
      return root;
    }
    return findHou(root.right);
  }

  static class Node {
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
  };
}
