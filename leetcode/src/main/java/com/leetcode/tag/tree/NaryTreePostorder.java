package com.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 */
public class NaryTreePostorder {
  List<Integer> result = new ArrayList<>();

  public List<Integer> postorder(Node root) {
    postOrder(root);

    return result;
  }

  /**
   * 后序遍历是回溯时处理数据.添加数据
   *
   * @param root
   */
  public void postOrder(Node root) {
    if (root == null) {
      return;
    }
    for (int i = 0; root.children != null && i < root.children.size(); i++) {
      postOrder(root.children.get(i));
    }
    result.add(root.val);
  }

  class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }
}
