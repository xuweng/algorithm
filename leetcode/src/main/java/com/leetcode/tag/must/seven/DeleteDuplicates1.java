package com.leetcode.tag.must.seven;

/**
 * 82. 删除排序链表中的重复元素 II
 */
public class DeleteDuplicates1 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode ya = new ListNode(-1, head);
            ListNode cur = ya;
            while (cur.next != null && cur.next.next != null) {
                if (cur.next.val == cur.next.next.val) {
                    int val = cur.next.val;
                    while (cur.next != null && cur.next.val == val) {
                        cur.next = cur.next.next;
                    }
                } else {
                    cur = cur.next;
                }
            }

            return ya.next;
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
