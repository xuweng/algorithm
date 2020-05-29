package com.leetcode.tag.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 337. 打家劫舍 III
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
}
