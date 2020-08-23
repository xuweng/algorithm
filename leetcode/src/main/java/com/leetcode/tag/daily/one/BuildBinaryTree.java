package com.leetcode.tag.daily.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildBinaryTree {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
      return null;
    }
    return re(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  /**
   * 找到所有分支
   *
   * <p>找到所有子问题
   *
   * <p>找到所有分支
   *
   * <p>找到所有子问题
   *
   * <p>找到所有子问题
   *
   * <p>找到所有分支
   *
   * @param preOrder
   * @param pI
   * @param pJ
   * @param inOrder
   * @param iI
   * @param iJ
   * @return
   */
  public TreeNode re(int[] preOrder, int pI, int pJ, int[] inOrder, int iI, int iJ) {
    if (pI > pJ || iI > iJ) {
      return null;
    }
    int root = preOrder[pI];

    // 中序root下标
    int i = iI;
    while (i <= iJ && root != inOrder[i]) {
      i++;
    }
    int leftCount = i - iI;
    TreeNode left = re(preOrder, pI + 1, pI + leftCount, inOrder, iI, i - 1);
    TreeNode right = re(preOrder, pI + leftCount + 1, pJ, inOrder, i + 1, iJ);
    TreeNode treeNode = new TreeNode(root);
    treeNode.left = left;
    treeNode.right = right;

    return treeNode;
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(
            int[] preorder,
            int[] inorder,
            int preorderLeft,
            int preorderRight,
            int inorderLeft,
            int inorderRight) {
      if (preorderLeft > preorderRight) {
        return null;
      }

      // 前序遍历中的第一个节点就是根节点
      int preorderRoot = preorderLeft;
      // 在中序遍历中定位根节点
      int inorderRoot = indexMap.get(preorder[preorderRoot]);

      // 先把根节点建立出来
      TreeNode root = new TreeNode(preorder[preorderRoot]);
      // 得到左子树中的节点数目
      int sizeLeftSubtree = inorderRoot - inorderLeft;
      // 递归地构造左子树，并连接到根节点
      // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
      root.left =
              myBuildTree(
                      preorder,
                      inorder,
                      preorderLeft + 1,
                      preorderLeft + sizeLeftSubtree,
                      inorderLeft,
                      inorderRoot - 1);
      // 递归地构造右子树，并连接到根节点
      // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
      root.right =
              myBuildTree(
                      preorder,
                      inorder,
                      preorderLeft + sizeLeftSubtree + 1,
                      preorderRight,
                      inorderRoot + 1,
                      inorderRight);
      return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
      int n = preorder.length;
      // 构造哈希映射，帮助我们快速定位根节点
      indexMap = new HashMap<>();
      for (int i = 0; i < n; i++) {
        indexMap.put(inorder[i], i);
      }
      return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
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
