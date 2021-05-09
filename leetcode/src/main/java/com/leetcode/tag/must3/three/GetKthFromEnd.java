package com.leetcode.tag.must3.three;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class GetKthFromEnd {
     class Solution {
         public ListNode getKthFromEnd(ListNode head, int k) {
             ListNode fast = head;
             for (int i = 0; i < k; i++) {
                 if (fast == null) {
                     return null;
                 }
                 fast = fast.next;
             }
             while (fast != null) {
                 head = head.next;
                fast = fast.next;
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
