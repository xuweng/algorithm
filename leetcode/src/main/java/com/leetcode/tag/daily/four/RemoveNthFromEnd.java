package com.leetcode.tag.daily.four;

/**
 * 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || head.next == null) {
                return null;
            }
            ListNode p1 = head, p2 = head, p3 = head;
            for (int i = 1; i < n && p1 != null; i++) {
                p1 = p1.next;
            }

            while (p1 != null && p1.next != null) {
                p3 = p2;
                p2 = p2.next;
                p1 = p1.next;
            }
            p3.next = p3.next.next;
            return head;
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
}
