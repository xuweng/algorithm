package com.leetcode.tag.daily.three;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode p1 = head.next;
            ListNode p2 = p1.next;

            p1.next = head;
            head.next = swapPairs(p2);
            return p1;
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
