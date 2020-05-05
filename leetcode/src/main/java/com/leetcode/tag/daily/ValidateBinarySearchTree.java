package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 */
public class ValidateBinarySearchTree {
  public boolean isValidBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    zhong(root, list);

    return isSort(list);
  }

  /**
   * 是否升序
   *
   * @param list
   * @return
   */
  public boolean isSort(List<Integer> list) {
    if (list == null) {
      return false;
    }
    if (list.isEmpty()) {
      return true;
    }
    if (list.size() == 1) {
      return true;
    }
    int max = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) <= max) {
        return false;
      }
      max = list.get(i);
    }

    return true;
  }

  public void zhong(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    // 先左子树放入list
    zhong(root.left, list);
    // root放入list
    list.add(root.val);
    // 后右子树放入list
    zhong(root.right, list);
  }

  /**
   * 判断是否bst
   *
   * <p>递归
   *
   * @param root
   */
  public boolean re(TreeNode root) {
    if (root == null) {
      return true;
    }
    // 叶子结点
    if (root.left == null && root.right == null) {
      return true;
    }
    TreeNode left = jieLeft(root.left);
    TreeNode right = jieRight(root.right);
    boolean l = (left == null) || (left.val < root.val);
    boolean r = (right == null) || (right.val > root.val);

    boolean c = re(root.left) && re(root.right);

    return c & l & r;
  }

  public TreeNode jieLeft(TreeNode root) {
    if (root == null) {
      return null;
    }
    // 叶子结点
    if (root.right == null) {
      return root;
    }
    return jieLeft(root.right);
  }

  public TreeNode jieRight(TreeNode root) {
    if (root == null) {
      return null;
    }
    // 叶子结点
    if (root.left == null) {
      return root;
    }
    return jieLeft(root.left);
  }

  /**
   * 如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值；
   *
   * <p>若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
   *
   * <p>它的左右子树也为二叉搜索树。
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    /**
     * 这个递归函数不太容易想到
     *
     * <p>上下界:官方通过传参,我需要在函数里面计算;传参代码简洁,但是不容易想到;在函数里面计算容易想到
     *
     * <p>这启示我们设计一个递归函数 helper(root, lower, upper) 来递归判断，函数表示考虑以 root 为根的子树，
     *
     * <p>判断子树中所有节点的值是否都在 (l,r) 的范围内（注意是开区间）。如果 root 节点的值 val 不在 (l,r)
     * 的范围内说明不满足条件直接返回，否则我们要继续递归调用检查它的左右子树是否满足，如果都满足才说明这是一棵二叉搜索树。
     *
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
      if (node == null) {
        return true;
      }
      // 下界
      if (lower != null && node.val <= lower) {
        return false;
      }
      // 上界
      if (upper != null && node.val >= upper) {
        return false;
      }

      return helper(node.right, node.val, upper) && helper(node.left, lower, node.val);
    }

    public boolean isValidBST(TreeNode root) {
      return helper(root, null, null);
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
