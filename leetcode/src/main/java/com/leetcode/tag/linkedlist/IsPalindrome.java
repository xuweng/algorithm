package com.leetcode.tag.linkedlist;

/**
 * 234. 回文链表
 */
public class IsPalindrome {
    class Solution {
        boolean result = true;
        ListNode pre;

        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return false;
            }
            pre = head;

            back(head);

            return result;
        }

        private void back(ListNode head) {
            if (head == null) {
                return;
            }
            back(head.next);
            if (head.val != pre.val) {
                result = false;
            }
            pre = pre.next;
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
