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
    static class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            List<List<TreeNode>> listNodes = new ArrayList<>();

            reCeng(tree, listNodes, 0);

            List<ListNode> result = new ArrayList<>();
            for (List<TreeNode> nodes : listNodes) {
                if (nodes.isEmpty()) {
                    continue;
                }
                ListNode head = new ListNode(nodes.get(0).val);
                //注意tail
                //在细节花太多时间
                ListNode tail = head;
                for (int i = 1; i < nodes.size(); i++) {
                    ListNode listNode = new ListNode(nodes.get(i).val);
                    tail.next = listNode;
                    tail = listNode;
                }
                result.add(head);
            }

            return result.toArray(new ListNode[0]);

        }

        /**
         * 模板
         * <p>
         * 递归写层次遍历
         *
         * @param treeNode
         * @param listNodes
         * @param high
         */
        private void reCeng(TreeNode treeNode, List<List<TreeNode>> listNodes, int high) {
            if (treeNode == null) {
                return;
            }
            if (listNodes.size() == high) {
                listNodes.add(new ArrayList<>());
            }
            listNodes.get(high).add(treeNode);
            reCeng(treeNode.left, listNodes, high + 1);
            reCeng(treeNode.right, listNodes, high + 1);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
