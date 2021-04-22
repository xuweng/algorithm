package com.leetcode.tag.must1.five;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class GetKthFromEnd {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            int count = 1;
            ListNode p = head;
            while (p != null && count < k) {
                count++;
                p = p.next;
            }
            while (p != null && p.next != null) {
                p = p.next;
                head = head.next;
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
