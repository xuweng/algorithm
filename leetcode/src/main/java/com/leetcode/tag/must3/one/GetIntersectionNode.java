package com.leetcode.tag.must3.one;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class GetIntersectionNode {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // a,b走的路程相等
            ListNode a = headA, b = headB;
            while (a != b) {
                a = a == null ? headB : a.next;
                b = b == null ? headA : b.next;
            }

            return a;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
