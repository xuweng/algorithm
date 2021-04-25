package com.leetcode.tag.must1.eight;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            return dfs(head);
        }

        private ListNode dfs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dfs = dfs(head.next.next);
            ListNode next = head.next;
            next.next = head;
            head.next = dfs;

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
