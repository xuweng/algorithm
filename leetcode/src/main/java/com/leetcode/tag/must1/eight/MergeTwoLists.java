package com.leetcode.tag.must1.eight;

/**
 * 21. 合并两个有序链表
 */
public class MergeTwoLists {
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode head;
            if (l1.val <= l2.val) {
                head = new ListNode(l1.val);
                head.next = mergeTwoLists(l1.next, l2);
            } else {
                head = new ListNode(l2.val);
                head.next = mergeTwoLists(l1, l2.next);
            }

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
