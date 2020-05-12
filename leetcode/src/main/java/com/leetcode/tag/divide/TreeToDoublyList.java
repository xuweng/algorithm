package com.leetcode.tag.divide;

/**
 * 递归同一层放心写.同一层不需要考虑顺序
 *
 * <p>面试题36. 二叉搜索树与双向链表
 */
public class TreeToDoublyList {
  public Node treeToDoublyList(Node root) {
    if (root == null) {
      return null;
    }
    Node hou = findHou(root);
    Node head = re(root);
    hou.right = head;
    head.left = hou;

    return head;
  }

  /**
   * 递归都是同一层,同一层不需要注意计算顺序
   *
   * @param root
   * @return
   */
  public Node re(Node root) {
    if (root == null) {
      return null;
    }
    // 注意计算顺序
    // 不需要注意顺序,都是一个root
    Node left = re(root.left);
    Node right = re(root.right);
    // 保存root前驱
    Node qian = findHou(root.left);
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
