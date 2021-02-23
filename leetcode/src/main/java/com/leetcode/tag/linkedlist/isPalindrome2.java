package com.leetcode.tag.linkedlist;

/**
 * 面试题 02.06. 回文链表
 */
public class isPalindrome2 {
    class Solution {
        ListNode pre;
        boolean result = true;

        public boolean isPalindrome(ListNode head) {
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

        ListNode(int x) {
            val = x;
        }
    }
}
