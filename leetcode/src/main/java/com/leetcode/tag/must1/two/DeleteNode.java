package com.leetcode.tag.must1.two;

/**
 * 237. 删除链表中的节点
 */
public class DeleteNode {
    class Solution {
        public void deleteNode(ListNode node) {
            if (node == null) {
                return;
            }
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
