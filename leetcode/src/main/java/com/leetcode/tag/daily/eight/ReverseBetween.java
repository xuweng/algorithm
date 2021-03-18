package com.leetcode.tag.daily.eight;

/**
 * 92. 反转链表 II
 */
public class ReverseBetween {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode ya = new ListNode(-1);
            ya.next = head;
            ListNode pre = ya;

            ListNode preNode = pre;
            ListNode leftNode = head;
            ListNode rightNode = head;
            ListNode cur = head;
            for (int i = 1; i <= right; i++) {
                if (i == left) {
                    preNode = pre;
                    leftNode = cur;
                }
                if (i == right) {
                    rightNode = cur;
                }
                pre = pre.next;
                cur = cur.next;
            }

            ListNode rightNodeNext = rightNode.next;

            preNode.next = null;
            rightNode.next = null;

            re(leftNode);

            preNode.next = rightNode;
            leftNode.next = rightNodeNext;

            return ya.next;
        }

        private void re(ListNode head) {
            ListNode pre = head;
            ListNode cur = head.next;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;

                pre = cur;
                cur = next;
            }
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
