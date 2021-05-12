package com.leetcode.tag.must3.five;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class TreeToDoublyList {
    class Solution {
        Node pre;
        Node head;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }

            dfs(root);
            pre.right = head;
            head.left = pre;

            return head;
        }

        private void dfs(Node root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (pre != null) {
                pre.right = root;
            } else {
                // 记录head
                head = root;
            }
            pre = root;
            root.left = pre;

            dfs(root.right);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
