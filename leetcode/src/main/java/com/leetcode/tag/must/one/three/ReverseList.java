package com.leetcode.tag.must.one.three;

/**
 * 206. 反转链表
 */
public class ReverseList {
    class Solution {
        ListNode listNode;

        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
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
            // 必须
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
