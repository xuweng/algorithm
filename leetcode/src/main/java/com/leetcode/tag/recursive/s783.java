package com.leetcode.tag.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 783. 二叉搜索树节点最小距离
 *
 * <p>最简单的方法.保证思路正确.最后优化
 *
 * <p>具体问题具体分析.不用死记硬背.具体问题具体分析.具体问题具体分析
 */
public class s783 {
  public int minDiffInBST(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    pre(root, list);

    Integer[] array = list.toArray(new Integer[list.size()]);

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        min = Math.min(min, Math.abs(array[i] - array[j]));
      }
    }

    return min;
  }

  public void pre(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    list.add(root.val);
    if (root.left != null) {
      pre(root.left, list);
    }
    if (root.right != null) {
      pre(root.right, list);
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
