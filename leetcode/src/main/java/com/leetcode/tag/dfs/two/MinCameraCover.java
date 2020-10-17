package com.leetcode.tag.dfs.two;

/**
 * 968. 监控二叉树
 * <p>
 * 本题并不是动态规划，其本质是贪心
 */
public class MinCameraCover {
    class Solution {
        int result = 0;

        public int minCameraCover(TreeNode root) {
            if (dfs(root) == 1) {
                result++;
            }
            return result;
        }

        //0:可被观测但无摄像机，上一层节点为1

        //下面2个状态容易理解
        //1：不可被观测到，上一层节点为2
        //2：有摄像机，上一层节点为0
        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftStatus = dfs(root.left);
            int rightStatus = dfs(root.right);
            if (leftStatus == 1 || rightStatus == 1) {
                //放摄像机
                result++;
                return 2;
            } else if (leftStatus == 2 || rightStatus == 2) {
                //可被观测但无摄像机
                return 0;
            } else {
                return 1;
            }
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
