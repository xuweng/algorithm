package com.leetcode.tag.divide;

/**
 * 面试题36. 二叉搜索树与双向链表
 */
public class TreeToDoublyList {
  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }
    Node hou = findHou(root);
    Node head = re(root);
    head.right = hou;
    hou.left = head;

    return head;
  }

  /**
   * 递归逻辑思维顺序
   *
   * <p>指针形成环
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
    Node left = re(root.left);
    Node right = re(root.right);
    if (qian != null) {
      qian.right = root;
    }
    root.left = qian;
    root.right = right;
    if (right != null) {
      right.left = root;
    }
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

    public Node() {}

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
