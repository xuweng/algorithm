package com.leetcode.tag.daily;

import java.util.*;

/**
 * dfs和bfs代码模板
 *
 * <p>102. 二叉树的层序遍历
 *
 * <p>能不能用递归
 *
 * <p>能不能用dp
 *
 * <p>子问题依赖和子问题重复不一样
 *
 * <p>子问题依赖是递归同一层的问题相互依赖.子问题重复不是在递归同一层
 */
public class BinaryTreeLevelOrderTraversal {
  /**
   * 用递归明显不对.左子树与右子树依赖
   *
   * <p>左子树.右子树.左子树和右子树依赖.子问题相互依赖
   *
   * <p>递归做的事太多
   *
   * <p>递归在同一层
   *
   * <p>递归只做一件事
   *
   * <p>是左子树,不是一个左结点
   *
   * <p>是右子树,不是一个右结点
   *
   * @param root
   * @param height
   * @param lists
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> lists = new ArrayList<>();
    Map<Integer, List<Integer>> map = new TreeMap<>();
    MyNode myNode = new MyNode(1, root);
    Queue<MyNode> queue = new LinkedList<>();
    queue.offer(myNode);
    while (!queue.isEmpty()) {
      MyNode treeNode = queue.poll();
      List<Integer> list = map.getOrDefault(treeNode.ceng, new ArrayList<>());
      list.add(treeNode.node.val);
      map.put(treeNode.ceng, list);
      if (treeNode.node.left != null) {
        MyNode node = new MyNode(treeNode.ceng + 1, treeNode.node.left);
        queue.offer(node);
      }
      if (treeNode.node.right != null) {
        MyNode node = new MyNode(treeNode.ceng + 1, treeNode.node.right);
        queue.offer(node);
      }
    }
    map.forEach(
            (k, v) -> {
              lists.add(v);
            });

    return lists;
  }

  /**
   * 高度
   *
   * @param root
   * @return
   */
  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(height(root.left), height(root.right)) + 1;
  }

  /**
   * 自定义数据结构
   */
  public class MyNode {
    int ceng;
    TreeNode node;

    public MyNode(int ceng, TreeNode node) {
      this.ceng = ceng;
      this.node = node;
    }
  }

  class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    /**
     * 这个递归很巧妙
     *
     * @param node
     * @param level
     */
    public void helper(TreeNode node, int level) {
      // start the current level
      if (levels.size() == level) {
        levels.add(new ArrayList<>());
      }

      // 填满当前层
      // fulfil the current level
      levels.get(level).add(node.val);

      // process child nodes for the next level
      if (node.left != null) {
        // 每层new一个list,左子树对应层先填满
        helper(node.left, level + 1);
      }
      if (node.right != null) {
        // 右子树不用new list,对应层填满
        helper(node.right, level + 1);
      }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
        return levels;
      }
      helper(root, 0);
      return levels;
    }
  }

  /**
   * 真正的层次遍历
   *
   * <p>作者：nettee
   * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/bfs-de-shi-yong-chang-jing-zong-jie-ceng-xu-bian-l/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   */
  // 二叉树的层序遍历
  void bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      // 在每一层遍历开始前，先记录队列中的结点数量 n（也就是这一层的结点数量），然后一口气处理完这一层的 n 个结点。
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        // 变量 i 无实际意义，只是为了循环 n 次
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }
  }

  public List<List<Integer>> levelOrder1(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();

    Queue<TreeNode> queue = new ArrayDeque<>();
    if (root != null) {
      queue.add(root);
    }
    while (!queue.isEmpty()) {
      int n = queue.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      res.add(level);
    }

    return res;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
