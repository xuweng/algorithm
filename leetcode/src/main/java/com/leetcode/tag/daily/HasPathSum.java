package com.leetcode.tag.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 *
 * <p>搞懂题目
 */
public class HasPathSum {
  /**
   * 根节点到叶子节点的路径
   *
   * @param root
   * @param sum
   * @return
   */
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    return re(root, sum);
  }

  public boolean re(TreeNode root, int sum) {
    if (root == null) {
      return sum == 0;
    }
    if (root.left == null && root.right == null) {
      return root.val == sum;
    }
    if (root.left != null && root.right == null) {
      return re(root.left, sum - root.val);
    }
    if (root.left == null) {
      return re(root.right, sum - root.val);
    }

    return re(root.left, sum - root.val) || re(root.right, sum - root.val);
  }

  /**
   * 方法一：广度优先搜索
   *
   * <p>作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/path-sum/solution/lu-jing-zong-he-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
      if (root == null) {
        return false;
      }
      // 存储将要遍历的节点
      Queue<TreeNode> queNode = new LinkedList<>();
      // 存储根节点到这些节点的路径和
      Queue<Integer> queVal = new LinkedList<>();
      queNode.offer(root);
      queVal.offer(root.val);
      while (!queNode.isEmpty()) {
        TreeNode now = queNode.poll();
        int temp = queVal.poll();
        if (now.left == null && now.right == null) {
          if (temp == sum) {
            return true;
          }
          continue;
        }
        // 代码模板
        if (now.left != null) {
          queNode.offer(now.left);
          queVal.offer(now.left.val + temp);
        }
        // 代码模板
        if (now.right != null) {
          queNode.offer(now.right);
          queVal.offer(now.right.val + temp);
        }
      }
      return false;
    }
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
