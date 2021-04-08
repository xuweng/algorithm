package com.leetcode.tag.must.one.three;

/**
 * 61. 旋转链表
 */
public class RotateRight {
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            ListNode cur = head;
            int n = 1;
            while (cur.next != null) {
                n++;
                cur = cur.next;
            }
            // 环
            cur.next = head;
            // 新head前去结点
            int index = n - (k % n) - 1;
            for (int i = 0; i < index; i++) {
                head = head.next;
            }
            ListNode newHead = head.next;
            // 断开
            head.next = null;

            return newHead;
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
