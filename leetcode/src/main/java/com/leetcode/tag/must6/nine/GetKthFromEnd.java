package com.leetcode.tag.must6.nine;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class GetKthFromEnd {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode cur = head;
            for (int i = 0; i < k; i++) {
                if (cur == null) {
                    return null;
                }
                cur = cur.next;
            }
            while (cur != null) {
                cur = cur.next;
                head = head.next;
            }

            return cur;
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
