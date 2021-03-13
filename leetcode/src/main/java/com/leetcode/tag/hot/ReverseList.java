package com.leetcode.tag.hot;

/**
 * 206. 反转链表
 */
public class ReverseList {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode listNode = reverseList(head.next);
            listNode.next = head;

            head.next = null;
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
