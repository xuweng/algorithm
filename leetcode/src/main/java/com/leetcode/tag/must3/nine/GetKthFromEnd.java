package com.leetcode.tag.must3.nine;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class GetKthFromEnd {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode node = head;
            for (int i = 0; i < k; i++) {
                if (node == null) {
                    return null;
                }
                node = node.next;
            }
            while (node != null) {
                head = head.next;
                node = node.next;
            }

            return head;
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
