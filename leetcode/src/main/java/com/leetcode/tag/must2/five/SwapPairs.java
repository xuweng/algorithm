package com.leetcode.tag.must2.five;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 可变参数 可变参数 可变参数
 * <p>
 * 可变参数 可变参数 可变参数
 */
public class SwapPairs {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode listNode = swapPairs(head.next.next);
            ListNode next = head.next;
            next.next = head;
            head.next = listNode;

            return next;
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
