package com.leetcode.tag.must1.six;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class GetKthFromEnd {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode p = head;
            for (int i = 0; i < k; i++) {
                p = p.next;
            }
            while (p != null) {
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
