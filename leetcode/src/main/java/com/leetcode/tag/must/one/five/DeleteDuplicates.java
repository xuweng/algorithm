package com.leetcode.tag.must.one.five;

/**
 * 83. 删除排序链表中的重复元素
 */
public class DeleteDuplicates {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode cur = head;
            while (cur.next != null) {
                if (cur.val == cur.next.val) {
                    ListNode next = cur.next;
                    cur.next = next.next;
                    next = null;
                } else {
                    cur = cur.next;
                }
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
