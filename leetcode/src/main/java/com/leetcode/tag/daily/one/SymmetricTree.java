package com.leetcode.tag.daily.one;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {
  /**
   * 假设求左子树是否对称，求右子树是否对称。没什么用。
   *
   * <p>左子树，右子树两个子问题。先搞定左子树，然后搞定右子树。
   *
   * <p>同时依赖左子树和右子树。子问题依赖。子问题不独立。
   *
   * @param root
   * @return
   */
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    List<List<Integer>> result = new ArrayList<>();

    levels(0, root, result);

    for (List<Integer> list : result) {
      int low = 0, high = list.size() - 1;
      while (low < high) {
        if (list.get(low) != (list.get(high))) {
          return false;
        }
        low++;
        high--;
      }
    }

    return true;
  }

  /**
   * 中序遍历不对
   *
   * @param root
   * @param result
   */
  public void levels(int level, TreeNode root, List<List<Integer>> result) {
    if (level == result.size()) {
      result.add(new ArrayList<>());
    }
    if (root == null) {
      result.get(level).add(null);
      return;
    }
    result.get(level).add(root.val);
    levels(level + 1, root.left, result);
    levels(level + 1, root.right, result);
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution {
    public boolean isSymmetric(TreeNode root) {
      return check(root, root);
    }

    /**
     * 递归思路清晰
     *
     * <p>如果同时满足下面的条件，两个树互为镜像：
     *
     * <p>它们的两个根结点具有相同的值
     *
     * <p>想到以下两点。没想到用两个参数。
     *
     * <p>每个树的右子树都与另一个树的左子树镜像对称
     *
     * <p>每个树的左子树都与另一个树的右子树镜像对称
     *
     * @param p
     * @param q
     * @return
     */
    public boolean check(TreeNode p, TreeNode q) {
      // p q同时为null
      if (p == null && q == null) {
        return true;
      }
      // p q一个为null，一个不为null
      if (p == null || q == null) {
        return false;
      }
      return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
  }

  /**
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class Solution1 {
    public boolean isSymmetric(TreeNode root) {
      return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
      Queue<TreeNode> q = new LinkedList<TreeNode>();
      q.offer(u);
      q.offer(v);
      while (!q.isEmpty()) {
        u = q.poll();
        v = q.poll();
        if (u == null && v == null) {
          continue;
        }
        if ((u == null || v == null) || (u.val != v.val)) {
          return false;
        }

        // 入队顺序
        q.offer(u.left);
        q.offer(v.right);

        q.offer(u.right);
        q.offer(v.left);
      }
      return true;
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
