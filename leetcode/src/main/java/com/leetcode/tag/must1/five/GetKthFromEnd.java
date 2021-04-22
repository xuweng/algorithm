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

    class Solution1 {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode former = head, latter = head;
            // 移动k步
            for (int i = 0; i < k; i++) {
                if (former == null) {
                    return null;
                }
                former = former.next;
            }
            // 一起移动
            while (former != null) {
                former = former.next;
                latter = latter.next;
            }
            return latter;
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
