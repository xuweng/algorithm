package com.leetcode.tag.daily;

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
