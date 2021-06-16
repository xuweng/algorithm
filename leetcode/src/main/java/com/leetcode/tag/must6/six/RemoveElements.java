package com.leetcode.tag.must6.six;

/**
 * 203. 移除链表元素
 */
public class RemoveElements {
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode ya = new ListNode(-1);
            ya.next = head;

            ListNode cur = ya;
            while (cur != null && cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }

            return ya.next;
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
