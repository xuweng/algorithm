package com.leetcode.tag.must.one.five;

/**
 * 206. 反转链表
 */
public class ReverseList {
    class Solution {
        ListNode listNode;

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return head;
            }

            dfs(head);

            return listNode;
        }

        private ListNode dfs(ListNode head) {
            if (head.next == null) {
                listNode = head;
                return head;
            }
            ListNode dfs = dfs(head.next);
            dfs.next = head;
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
