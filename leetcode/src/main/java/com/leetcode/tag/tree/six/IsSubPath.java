package com.leetcode.tag.tree.six;

/**
 * 1367. 二叉树中的列表
 */
public class IsSubPath {
    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            return (root != null) && (check(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right));
        }

        private boolean check(ListNode head, TreeNode root) {
            if (root == null) {
                return head == null;
            }
            if (head == null || head.val != root.val) {
                return false;
            }
            return check(head.next, root.left) || check(head.next, root.right);
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
