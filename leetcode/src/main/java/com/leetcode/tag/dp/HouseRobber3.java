package com.leetcode.tag.dp;

import java.util.*;

/**
 * 线性结构.用线性dp。
 *
 * <p>树状dp。树状dp。树状dp。树状dp。树状dp。
 *
 * <p>十分钟看答案。十分钟看答案。十分钟看答案。十分钟看答案。十分钟看答案。十分钟看答案。
 *
 * <p>337. 打家劫舍 III
 */
public class HouseRobber3 {
  public int rob(TreeNode root) {
    if (root == null) {
      return 0;
    }
    List<Integer> result = new ArrayList<>();
    bianLi(root, result);

    if (result.size() == 1) {
      return result.get(0);
    }
    if (result.size() == 2) {
      return Math.max(result.get(0), result.get(1));
    }
    int[] dp = new int[result.size()];
    dp[0] = result.get(0);
    dp[1] = Math.max(result.get(0), result.get(1));
    for (int i = 2; i < result.size(); i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + result.get(i));
    }
    return dp[dp.length - 1];
  }

  public void bianLi(TreeNode root, List<Integer> result) {
    if (root == null) {
      return;
    }
    bianLi(root.left, result);
    result.add(root.val);
    bianLi(root.right, result);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  class S {
    public int rob(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      Deque<Integer> deque = new ArrayDeque<>();

      backTrack(root, result, deque);

      return 0;
    }

    /**
     * 保存从root到叶子结点的所有路径
     *
     * @param root
     * @param result
     * @param deque
     */
    public void backTrack(TreeNode root, List<List<Integer>> result, Deque<Integer> deque) {
      if (root == null) {
        result.add(new ArrayList<>(deque));
        return;
      }
      deque.push(root.val);
      backTrack(root.left, result, deque);
      deque.pop();

      deque.push(root.val);
      backTrack(root.right, result, deque);
      deque.pop();
    }
  }

  /**
   * 首先要明确相邻的节点不能偷，也就是爷爷选择偷，儿子就不能偷了，
   *
   * <p>但是孙子可以偷 二叉树只有左右两个孩子，一个爷爷最多 2 个儿子，4 个孙子
   */
  class S1 {
    /**
     * 递归思路清晰。选择root。不选择root。
     *
     * <p>max(选择root,不选择root)
     *
     * <p>作者：reals
     * 链接：https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
      if (root == null) {
        return 0;
      }

      // max(选择root,不选择root)
      int money = root.val;
      if (root.left != null) {
        money += (rob(root.left.left) + rob(root.left.right));
      }

      if (root.right != null) {
        money += (rob(root.right.left) + rob(root.right.right));
      }

      return Math.max(money, rob(root.left) + rob(root.right));
    }
  }

  /**
   * 记忆化 - 解决重复子问题
   *
   * <p>作者：reals
   * 链接：https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  class S2 {

    public int rob(TreeNode root) {
      HashMap<TreeNode, Integer> memo = new HashMap<>();
      return robInternal(root, memo);
    }

    public int robInternal(TreeNode root, HashMap<TreeNode, Integer> memo) {
      if (root == null) {
        return 0;
      }
      if (memo.containsKey(root)) {
        return memo.get(root);
      }
      int money = root.val;

      if (root.left != null) {
        money += (robInternal(root.left.left, memo) + robInternal(root.left.right, memo));
      }
      if (root.right != null) {
        money += (robInternal(root.right.left, memo) + robInternal(root.right.right, memo));
      }
      int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
      memo.put(root, result);

      return result;
    }
  }
}
