package com.leetcode.tag.must.two;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 652. 寻找重复的子树
 */
public class FindDuplicateSubtrees {
    class Solution {
        // 记录所有子树以及出现的次数
        HashMap<String, Integer> memo = new HashMap<>();
        // 记录重复的子树根节点
        LinkedList<TreeNode> res = new LinkedList<>();

        /* 主函数 */
        List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            traverse(root);

            return res;
        }

        String traverse(TreeNode root) {
            if (root == null) {
                return "#";
            }

            String left = traverse(root.left);
            String right = traverse(root.right);

            // 序列化
            String subTree = left + "," + right + "," + root.val;
            int freq = memo.getOrDefault(subTree, 0);
            // 多次重复也只会被加入结果集一次
            if (freq == 1) {
                res.add(root);
            }
            // 给子树对应的出现次数加一
            memo.put(subTree, freq + 1);
            return subTree;
        }
    }

    class TreeNode {
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
