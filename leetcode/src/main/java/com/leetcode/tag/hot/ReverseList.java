package com.leetcode.tag.hot;

/**
 * 206. 反转链表
 */
public class ReverseList {
    class Solution {
        ListNode node;

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode re = re(head);
            re.next = null;

            return node;
        }

        private ListNode re(ListNode head) {
            if (head.next == null) {
                node = head;
                return head;
            }
            re(head.next).next = head;

            return head;
        }
    }

    class Solution1 {
        ListNode node;

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            re(head);

            return node;
        }

        private ListNode re(ListNode head) {
            if (head.next == null) {
                node = head;
                return head;
            }
            re(head.next).next = head;
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
