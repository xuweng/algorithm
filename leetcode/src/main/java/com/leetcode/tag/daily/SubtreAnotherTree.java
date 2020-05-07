package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 与树相关首先想到递归
 *
 * <p>572. 另一个树的子树
 */
public class SubtreAnotherTree {
  /**
   * 2个参数递归终止条件
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) {
      return t == null;
    }
    // 这个递归终止条件错误
    // 仔细分析,需要考虑叶子结点
    if (t == null) {
      return false;
    }
    // t是叶子结点
    if (t.left == null && t.right == null) {
      // s也是叶子结点
      if ((s.left == null && s.right == null)) {
        return s.val == t.val;
      } else {
        return isSubtree(s.left, t) || isSubtree(s.right, t);
      }
    }
    // 相同结构
    if (s.val == t.val) {
      return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
    }

    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  /**
   * 用遍历方法错误
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isSubtree1(TreeNode s, TreeNode t) {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();

    pre(s, l1);
    pre(t, l2);

    int j = 0;
    for (int i = 0; i < l1.size(); i++) {
      Integer integer = l1.get(i);
      if (integer.equals(l2.get(0))) {
        j = i;
      }
    }

    return l2.size() == j;
  }

  public void pre(TreeNode s, List<Integer> list) {
    if (s == null) {
      return;
    }
    pre(s.left, list);
    list.add(s.val);
    pre(s.right, list);
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
