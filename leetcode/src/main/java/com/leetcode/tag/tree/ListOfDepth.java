package com.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.03. 特定深度节点链表
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 * <p>
 * 十分钟看题解
 * <p>
 * 层次遍历
 * <p>
 * 层次遍历
 */
public class ListOfDepth {
    class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            List<List<TreeNode>> listNodes = new ArrayList<>();

            ceng(tree, listNodes, 0);

            List<ListNode> result = new ArrayList<>();
            for (List<TreeNode> nodes : listNodes) {
                if (nodes.isEmpty()) {
                    continue;
                }
                ListNode head = new ListNode(nodes.get(0).val);
                for (int i = 1; i < nodes.size(); i++) {
                    head.next = new ListNode(nodes.get(i).val);
                }
                result.add(head);
            }

            return result.toArray(new ListNode[0]);

        }

        private void ceng(TreeNode treeNode, List<List<TreeNode>> listNodes, int high) {
            if (treeNode == null) {
                return;
            }
            if (listNodes.size() == high) {
                listNodes.add(new ArrayList<>());
            }
            listNodes.get(high).add(treeNode);
            ceng(treeNode.left, listNodes, high + 1);
            ceng(treeNode.right, listNodes, high + 1);
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
